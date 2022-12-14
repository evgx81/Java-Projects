package evgx81.mathematical_expression_parser;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.ArrayList;

import org.junit.Test;

/**
 *  Unit тесты для класса Parser.
 * 
 * @author evgx81 
 */
public class ParserTest {

    @Test
    public void createParser() {
        String exp = "-2*(2-3)*(2+2)";

        Parser parser = new Parser(exp);
        assertEquals(exp, parser.getExpression());
        assertEquals(null, parser.getVariables());
    }

    @Test
    public void createParserWithVariables() {
        String exp = "-2*(2-3)*x";
        HashMap<String, Number> vars = new HashMap<String, Number>();
        vars.put("x", 1);
        vars.put("y", 2);
        vars.put("z", 3);

        Parser parser = new Parser(exp, vars);

        ArrayList<String> varNames = new ArrayList<String>(parser.getVariables().keySet());
        ArrayList<BigDecimal> varVals = new ArrayList<BigDecimal>(parser.getVariables().values());

        HashMap<String, BigDecimal> test = new HashMap<String, BigDecimal>();
        test.put("x", new BigDecimal(1));
        test.put("y", new BigDecimal(2));
        test.put("z", new BigDecimal(3));

        ArrayList<String> testVarNames = new ArrayList<String>(test.keySet());
        ArrayList<BigDecimal> testVarVals = new ArrayList<BigDecimal>(test.values());

        assertEquals(exp, parser.getExpression());
        for (int i = 0; i < testVarNames.size(); i++) {
            assertEquals(testVarNames.get(i), varNames.get(i));
        }
        
        for (int i = 0; i < testVarVals.size(); i++) {
            assertEquals(testVarVals.get(i), varVals.get(i));
        }
        
    }

    @Test
    public void evaluateExpressionTest() {
        String exp1 = "2+3";
        String exp2 = "2-3";

        Parser parser1 = new Parser(exp1);
        Parser parser2 = new Parser(exp2);

        assertEquals(new BigDecimal(5), parser1.eval());
        assertEquals(new BigDecimal(-1), parser2.eval());
    }

    @Test
    public void evaluateTermTest() {
        String exp1 = "2^3";
        String exp2 = "2*3";
        String exp3 = "4/2";

        Parser parser1 = new Parser(exp1);
        Parser parser2 = new Parser(exp2);
        Parser parser3 = new Parser(exp3);

        assertEquals(new BigDecimal(8), parser1.eval());
        assertEquals(new BigDecimal(6), parser2.eval());
        assertEquals(new BigDecimal(2), parser3.eval());
    }

    @Test
    public void bracketsTest() {
        String exp1 = "(2+3)^2";
        String exp2 = "[2+3]^2";
        String exp3 = "{2+3}^2";

        Parser parser1 = new Parser(exp1);
        Parser parser2 = new Parser(exp2);
        Parser parser3 = new Parser(exp3);

        assertEquals(new BigDecimal(25), parser1.eval());
        assertEquals(new BigDecimal(25), parser2.eval());
        assertEquals(new BigDecimal(25), parser3.eval());
    }

    @Test(expected = IllegalArgumentException.class)
    public void missingBracketsTest() {
        String exp = "(2+3)^2)";

        Parser parser = new Parser(exp);
        parser.eval();
    }

    @Test
    public void evaluatePowerTest() {
        String exp = "2*2^10+1";

        Parser parser = new Parser(exp);
        assertEquals(new BigDecimal(2049), parser.eval());
    }

    @Test
    public void evaluateFactorSqrtTest() {
        String exp = "sqrt(4)";

        Parser parser = new Parser(exp);
        assertEquals(new BigDecimal(2), parser.eval());
    }

    @Test
    public void evaluateFactorSinTest() {
        String exp = "sin(0)";

        Parser parser = new Parser(exp);
        assertEquals(BigDecimal.ZERO, parser.eval());
    }

    @Test
    public void evaluateFactorCosTest() {
        String exp = "cos(0)";

        Parser parser = new Parser(exp);
        assertEquals(BigDecimal.ONE, parser.eval());
    }

    @Test
    public void evaluateFactorTgTest() {
        String exp = "tg(0)";

        Parser parser = new Parser(exp);
        assertEquals(BigDecimal.ZERO, parser.eval());
    }

    @Test
    public void evaluateFactorArcsinTest() {
        String exp = "arcsin(0)";

        Parser parser = new Parser(exp);
        assertEquals(BigDecimal.ZERO, parser.eval());
    }

    @Test
    public void evaluateFactorArccosTest() {
        String exp = "arccos(1)";

        Parser parser = new Parser(exp);
        assertEquals(BigDecimal.ZERO, parser.eval());
    }

    @Test
    public void evaluateFactorArctgTest() {
        String exp = "tg(0)";

        Parser parser = new Parser(exp);
        assertEquals(BigDecimal.ZERO, parser.eval());
    }

    @Test
    public void evaluateFactorSgnTest() {
        String exp1 = "sgn(5)";
        String exp2 = "sgn(0)";
        String exp3 = "sgn(-5)";

        Parser parser1 = new Parser(exp1);
        Parser parser2 = new Parser(exp2);
        Parser parser3 = new Parser(exp3);

        assertEquals(new BigDecimal(1), parser1.eval());
        assertEquals(new BigDecimal(0), parser2.eval());
        assertEquals(new BigDecimal(-1), parser3.eval());
    }

    @Test
    public void evaluateFactorAbsTest() {
        String exp1 = "abs(5)";
        String exp2 = "abs(0)";
        String exp3 = "abs(-5)";

        Parser parser1 = new Parser(exp1);
        Parser parser2 = new Parser(exp2);
        Parser parser3 = new Parser(exp3);

        assertEquals(new BigDecimal(5), parser1.eval());
        assertEquals(new BigDecimal(0), parser2.eval());
        assertEquals(new BigDecimal(5), parser3.eval());

    }

    @Test(expected = IllegalArgumentException.class)
    public void evaluateFactorWrongFunctionTest() {
        String exp = "srt(5)";

        Parser parser = new Parser(exp);

       parser.eval();
    }

    @Test(expected = IllegalArgumentException.class)
    public void evaluateFactorMissingBracketTest() {
        String exp = "srt(5)}";

        Parser parser = new Parser(exp);

       parser.eval();
    }
    
}
