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
}