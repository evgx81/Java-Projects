package evgx81.mathematical_expression_parser;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.ArrayList;

import org.junit.Test;

public class ParserTest {

    @Test
    public void createParser() {
        String exp = "-2*(2-3)(2+2)";

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

    @Test(expected = IllegalArgumentException.class)
    public void evalExpressionWithVariablesWithoutTheirSetting() {
        String exp = "-2*(2-3)*x";
        Parser parser = new Parser(exp);
        parser.eval();
    }

}
