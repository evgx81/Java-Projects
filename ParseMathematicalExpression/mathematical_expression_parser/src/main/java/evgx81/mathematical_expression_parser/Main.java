package evgx81.mathematical_expression_parser;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Класс Main демонстрирует возможности класса Parser.
 * 
 * @author evgx81 
 */
public class Main 
{
    public static void main(String[] args )
    {   
        String exp1 = "abs(-3)+cos(0)^2+x*2";
        HashMap<String, Number> vars = new HashMap<String, Number>();
        vars.put("x", 5);

        Parser parser = new Parser(exp1, vars);
        BigDecimal res = parser.eval();
        System.out.println("Результат: " + res);
    }
}