package evgx81.mathematical_expression_parser;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс Parser реализует разбор математического выражения и вычисление его значения.
 * 
 * @author evgx81 
 */
public class Parser {
    /** 
     * Заданное математическое выражение.
     * */
    private String expression;

    /** 
     * Хэш-таблица для хранения пар: ("Переменная" - "Значение переменной") 
     * */
    private HashMap<String, BigDecimal> variables;

    /**
     * Создает парсер, который принимает на вход заданное математическое выражение.
     * Предполагается, что заданное выражение не содержит переменных.
     * 
     * @param expression заданная строка
     */
    public Parser(String expression) {
        // Удаляем все пробелы из выражения с помощью регулярных выражений
        this.expression = expression.replaceAll("\\s","");
    }

    /**
     * Создает парсер, который принимает на вход заданное математическое выражение.
     * Предполагается, что заданное выражение содержит переменные.
     * 
     * @param expression заданная строка
     */
    public Parser(String expression, HashMap<String, ? extends Number> variables) {
        // Удаляем все пробелы из выражения с помощью регулярных выражений
        this.expression = expression.replaceAll("\\s","");

        this.variables = new HashMap<String, BigDecimal>();

        // Копируем содержимое переданного ассоциативного массива, 
        // приводя значения переменных к типу BigDecimal
        for (Map.Entry<String, ? extends Number> entry : variables.entrySet()) {
            this.variables.put(entry.getKey(), new BigDecimal(entry.getValue().toString()));
        }
    }

    // get методы для полей expression и variables
    public String getExpression() {
        return expression;
    }

    public Map<String, BigDecimal> getVariables() {
        return variables;
    }

    /**
     * Получаем строку, содержащую первый символ заданной строки.
     * 
     * @param s заданная строка 
     * @return строка, содержащую первый символ
     */
    private String getExpFirstSymb(String s) {
        return (s != null && s.length() > 0) ? s.substring(0, 1) : "";
    }

    /**
     * Получаем строку без первого символа заданной строки.
     * 
     * @param s заданная строка 
     * @return строка без первого символа
     */
    private String getExpRestPart(String s) {
        return (s != null && s.length() > 1) ? s.substring(1) : "";
    }

    /**
     * Возвращает вычисленное значение выражения
     * 
     * @return значение выражения
     */
    public BigDecimal eval() {
        return expressionEvaluation();
    }

    /**
     *  Вычисляем значения формулы, содержащей операции типа возведения в степень, умножения и деления.
     * 
     * @return значение формулы
     * @throws ArithmeticException при делении на нуль
     */
    private BigDecimal evaluateTerm() throws ArithmeticException{
        String operation = "";
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal num = BigDecimal.ZERO;

        result = evaluateFactor();
        boolean flag = true;
        while (flag) {
            operation = getExpFirstSymb(expression);
            if ("^".equals(operation)) {
                expression = getExpRestPart(expression);
                result = result.pow(evaluateFactor().intValue());
            }
            if ("*".equals(operation)) {
                expression = getExpRestPart(expression);
                result = result.multiply(evaluateFactor());
            } 
            else if ("/".equals(operation)) {
                expression = getExpRestPart(expression);
                try {
                    num = evaluateFactor();
                    result = result.divide(num);
                } 
                catch (ArithmeticException e) {
                    throw e;
                }
            } 
            else
                flag = false;
        }
        
        return result;
    }

    /**
     * Вычисляем значение простейшей формулы, 
     * являющейся либо числом, либо произвольной формулой, 
     * заключенной в круглые скобки, либо функцией, либо переменной.
     * 
     * @return число или значение формулы, заключенной в круглые скобки, или значение функции или значение переменной
     * @throws IllegalArgumentException если отсутствует закрывающая скобка
     */
    private BigDecimal evaluateFactor() throws IllegalArgumentException {
        BigDecimal result = BigDecimal.ZERO;
        String number = "";
        String identifier = "";
        BigDecimal functionArgument = BigDecimal.ZERO;

        String symb = getExpFirstSymb(expression);

        // Проверяем, является ли считанный символ частью числа.
        // Если это условие выполняется, то создаем новое число 
        // и рассматриваем оставшуюся часть выражения.
        if (symb.matches("[0-9\\.]")) {
            boolean flag = true;
            while (flag) {
                symb = getExpFirstSymb(expression);
                if (symb.matches("[0-9\\.]")) {
                    number += getExpFirstSymb(expression);
                    expression = getExpRestPart(expression);
                } 
                else {
                    result = new BigDecimal(number);
                    flag = false;
                }
            }
        }
        // Проверяем, является ли считанный символ закрывающей скобкой.
        // Если это условие выполняется, то высчитываем значение формулы в скобках,
        // и рассматриваем оставшуюся часть выражения.
        else if (symb.equals("(") || symb.equals("[") || symb.equals("{")) {
            expression = getExpRestPart(expression);
            result = expressionSum();
            if (!")".equals(getExpFirstSymb(expression)) || !"]".equals(getExpFirstSymb(expression)) || !"}".equals(getExpFirstSymb(expression))) {
                throw new IllegalArgumentException("Syntax error in brackets!");
            } 
            else 
                expression = getExpRestPart(expression);
        }
        // Проверяем, является ли символ частью переменной или функции.
        // Если символ является частью функции, то получаем аргумент и высчитываем значение функции
        // найденным аргументом.
        // Если символ является частью переменной, то создаем переменную и подставляем в результат.
        // Далее рассматриваем оставшуюся часть выражения.
        else if (symb.matches("[a-zA-Z]")) {
            boolean flag = true;
            while (flag) {
                symb = getExpFirstSymb(expression);
                if (symb.matches("[a-zA-Z]")) {
                    identifier += getExpFirstSymb(expression);
                    expression = getExpRestPart(expression);
                } 
                else if (symb.equals("(") || symb.equals("[") || symb.equals("{")) {
                    expression = getExpRestPart(expression);
                    functionArgument = expressionSum();
                    if (!")".equals(getExpFirstSymb(expression)) || !"]".equals(getExpFirstSymb(expression)) || !"}".equals(getExpFirstSymb(expression))) {
                        throw new IllegalArgumentException("Syntax error in brackets!");
                    } 
                    else {
                        expression = getExpRestPart(expression);
                        result = evaluateFunction(identifier, functionArgument);
                        flag = false;
                    }
                } 
                else {
                    result = variables.get(identifier);
                    if (result == null) {
                        throw new IllegalArgumentException("Undefined variable '" + identifier + "'");
                    } 
                    else
                        flag = false;
                }
            }
        }

        return result;
    }

    /**
     * Проверяет, соответсвует ли под строка функции, которую может обработать парсер.
     * Если да, то высчитываем значение функции, иначе - выбрасываем исключение.
     * 
     * @param funcName заданная строка
     * @param funcArg аргумент функции
     * @return значение функции
     * @throws IllegalArgumentException если строка не соотвествует функции, которую может обработать парсер
     */
    private BigDecimal evaluateFunction(String funcName, BigDecimal funcArg) throws IllegalArgumentException {
        if ("sqrt".equals(funcName.toLowerCase()))
            return new BigDecimal(Math.sqrt(funcArg.doubleValue()));
        else if ("sin".equals(funcName.toLowerCase()))
            return new BigDecimal(Math.sin(funcArg.doubleValue()));
        else if ("cos".equals(funcName.toLowerCase()))
            return new BigDecimal(Math.cos(funcArg.doubleValue()));
        else if ("tg".equals(funcName.toLowerCase()))
            return new BigDecimal(Math.tan(funcArg.doubleValue()));
        else if ("asin".equals(funcName.toLowerCase()))
            return new BigDecimal(Math.asin(funcArg.doubleValue()));
        else if ("acos".equals(funcName.toLowerCase()))
            return new BigDecimal(Math.acos(funcArg.doubleValue()));
        else if ("atan".equals(funcName.toLowerCase()))
            return new BigDecimal(Math.atan(funcArg.doubleValue()));
        else if ("sgn".equals(funcName.toLowerCase()))
            return new BigDecimal(funcArg.signum());
        else if ("abs".equals(funcName.toLowerCase()))
            return funcArg.abs();
        else 
            throw new IllegalArgumentException("Undefined function '" + funcName + "'");
    }
}