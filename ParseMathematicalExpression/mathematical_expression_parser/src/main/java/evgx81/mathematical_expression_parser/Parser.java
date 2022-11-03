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
     * Хэш-таблица для хранения пар ("Переменная" - "Значение переменной") 
     * */
    private HashMap<String, BigDecimal> variables;

    /**
     * Создает парсер, который принимает на вход заданное математическое выражение.
     * Предполагается, что заданное выражение не содержит переменных.
     * 
     * @param expression заданная строка
     */
    public Parser(String expression) {
        // Добавить проверку на поиск переменных
        this.expression = expression.replaceAll("\\s","");
    }

    /**
     * Создает парсер, который принимает на вход заданное математическое выражение.
     * Предполагается, что заданное выражение содержит переменные.
     * 
     * @param expression заданная строка
     */
    public Parser(String expression, HashMap<String, ? extends Number> variables) {
        // Удаляем из выражения все пробелы, использкя регулярные выражения
        this.expression = expression.replaceAll("\\s","");

        this.variables = new HashMap<String, BigDecimal>();

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
     * Вычисляем значение
     * 
     * @return
     */
    private BigDecimal expressionNumber() {
        BigDecimal result = BigDecimal.ZERO;
        String number = "";
        String identifier = "";
        BigDecimal functionArgument = BigDecimal.ZERO;

        String symb = getExpFirstSymb(expression);

        // переделать регулярные выражения
        // Проверяем, является ли считанный символ частью числа
        // Если это условие выполняется, то создаем новое число
        if (symb.matches("[0-9\\.]")) {
            boolean flag = true;
            while (flag) {
                symb = getExpFirstSymb(expression);
                if (symb.matches("[0-9\\.]")) {
                    number += getExpFirstSymb(expression);
                    expression = getExpRestPart(expression);
                } else {
                    result = new BigDecimal(number);
                    flag = false;
                }
            }
        }
        // Проверяем, является ли считанный символ закрывающей скобкой
        // Если это условие выполняется, то 
        // добавить поддержку других скобок
        else if (symb.equals("(")) {
            expression = getExpRestPart(expression);
            result = expressionSum();
            if (!")".equals(getExpFirstSymb(expression))) {
                throw new IllegalArgumentException("Syntax error");
            } 
            else 
                expression = getExpRestPart(expression);
        }
        // Проверяем, явдяется ли ли символ переенной или функцией
        else if (symb.matches("[a-zA-Z]")) {
            boolean flag = true;
            while (flag) {
                symb = getExpFirstSymb(expression);
                if (symb.matches("[a-zA-Z]")) {
                    identifier += getExpFirstSymb(expression);
                    expression = getExpRestPart(expression);
                } 
                else if (symb.equals("(")) {
                    expression = getExpRestPart(expression);
                    functionArgument = expressionSum();
                    if (!")".equals(getExpFirstSymb(expression))) {
                        throw new IllegalArgumentException("Syntax error");
                    } else {
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

    private BigDecimal expressionOperator() {
        String operation;
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal num = BigDecimal.ZERO;

        result = expressionNumber();
        boolean flag = true;
        while (flag) {
            operation = getExpFirstSymb(expression);
            // Подумать, как обработать корень
            if ("^".equals(operation)) {
                expression = getExpRestPart(expression);
                result = result.pow(expressionNumber().intValue());
            }
            if ("*".equals(operation)) {
                expression = getExpRestPart(expression);
                result = result.multiply(expressionNumber());
            } else if ("/".equals(operation)) {
                expression = getExpRestPart(expression);
                try {
                    num = expressionNumber();
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

    private BigDecimal evaluateFunction(String functionName, BigDecimal functionArgument) {
        // может сюда добавить степень 
        if ("sqrt".equalsIgnoreCase(functionName))
            return new BigDecimal(Math.sqrt(functionArgument.doubleValue()));
        else if ("sin".equalsIgnoreCase(functionName))
            return new BigDecimal(Math.sin(functionArgument.doubleValue()));
        else if ("cos".equalsIgnoreCase(functionName))
            return new BigDecimal(Math.cos(functionArgument.doubleValue()));
        else if ("tan".equalsIgnoreCase(functionName))
            return new BigDecimal(Math.tan(functionArgument.doubleValue()));
        else if ("asin".equalsIgnoreCase(functionName))
            return new BigDecimal(Math.asin(functionArgument.doubleValue()));
        else if ("acos".equalsIgnoreCase(functionName))
            return new BigDecimal(Math.acos(functionArgument.doubleValue()));
        else if ("atan".equalsIgnoreCase(functionName))
            return new BigDecimal(Math.atan(functionArgument.doubleValue()));
        else if ("sgn".equalsIgnoreCase(functionName))
            return new BigDecimal(functionArgument.signum());
        else if ("abs".equalsIgnoreCase(functionName))
            return functionArgument.abs();
        else 
            throw new IllegalArgumentException("Undefined function '" + functionName + "'");
    }

    private BigDecimal expressionSum() {
        String operation;
        BigDecimal result;

        result = expressionOperator();
        boolean flag = true;
        while (flag) {
            operation = getExpFirstSymb(expression);
            if ("+".equals(operation)) {
                expression = getExpRestPart(expression);
                result = result.add(expressionOperator());
            } 
            else if ("-".equals(operation)) {
                expression = getExpRestPart(expression);
                result = result.subtract(expressionOperator());
            } 
            else 
                flag = false;
        }
        return result;
    }

    public BigDecimal eval() {
        return expressionSum();
    }
}

 // public void setVariable(String varName, Double varValue) {
    //     variables.put(varName, varValue);
    // }

    // public void setExpression(String expression) {
    //     this.expression = expression;
    // }

    // private boolean isBracket(char ch) {
    //     return ch == '(' || ch == '[' || ch == '{' || 
    //         ch == ')' || ch == ']' || ch == '}';
    // }

    // private boolean isOperator(char curSymb) {
    //     return curSymb == '*' || curSymb == '+' || 
    //         curSymb == '-' || curSymb == '/' || curSymb == '^';
    // }

    // public boolean checkForBalancedBrackets() {

    //     // Создаем строку, которая будет содержать 
    //     StringBuilder tempStr = new StringBuilder();
    //     for (char ch : expression.toCharArray()) {
    //         if (isBracket(ch))
    //             tempStr.append(ch);
    //     }

    //     // Провереряем на баланс скобок
    //     Deque<Character> deque = new LinkedList<Character>();
    //     for (char symb : tempStr.toString().toCharArray()) {
    //         if (symb == '(' || symb == '[' || symb == '{')
    //             deque.addFirst(symb); 
    //         else {
    //             if (!deque.isEmpty() && 
    //                 ((deque.peekFirst() == '{' && symb == '}') ||
    //                 (deque.peekFirst() == '[' && symb == ']') ||
    //                 (deque.peekFirst() == '(' && symb == ')'))) {
    //                     deque.removeFirst();
    //             } 
    //             else
    //                 return false;
    //         }
    //     }
    //     return true;
    // }

    // public LinkedList<String> getExpressionComponents() {
    //     LinkedList<String> components = new LinkedList<String>();
    //     int i = 0;
    //     while (i < expression.length()) {

    //         char symb = expression.charAt(i); 

    //         if(isBracket(symb))
    //             components.add(Character.toString(symb));
    //         if(isOperator(symb))
    //             components.add(Character.toString(symb));
    //         if (Character.isDigit(symb)) {
    //             int j = i;
    //             StringBuilder number = new StringBuilder();
    //             int dot_cnt = 0;
    //             while (j < expression.length() && (Character.isDigit(expression.charAt(j)))) {
    //                 if (expression.charAt(j) == '.')
    //                     dot_cnt++;

    //                 if (dot_cnt > 1)
    //                     System.out.println("Не то что-то");
    //                 number.append(expression.charAt(j));
    //                 j++;
    //             }
    //             components.add(number.toString());
    //             i = j-1;
    //         }
    //         i++;
    //     }

    //     return components;
    // } 

    // private int characterPrecedence(char symb) {
    //     if (symb == '+' || symb == '-')
    //         return 1;
    //     else if (symb == '*' || symb == '/')
    //         return 2;
    //     else if (symb == '^')
    //         return 3;
    //     return 0;
    // }

    // private String getPostfixFromInfix() {
    //     Stack<String> stack = new Stack<String>();
    //     StringBuilder postfix = new StringBuilder();

    //     // for(int i = 0; i < expression.length(); i++) {

    //     // }
    // }