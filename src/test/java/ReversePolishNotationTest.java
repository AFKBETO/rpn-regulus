import org.junit.Assert;
import org.junit.Test;

import static org.example.ReversePolishNotation.evaluateRPN;
import static org.junit.Assert.assertTrue;

public class ReversePolishNotationTest {

    @Test
    public void testSqrtFail() throws IllegalArgumentException {
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            evaluateRPN("sqrt");
        });
        assertTrue(exception.getMessage().contains("Error: expecting one argument for sqrt, but got less than one argument"));
    }

    @Test
    public void testSqrtOK() throws IllegalArgumentException {
        Assert.assertEquals(3.0, evaluateRPN("9 sqrt"), 0.0);
    }

    @Test
    public void testLessArg() throws IllegalArgumentException {
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            evaluateRPN("3 +");
        });
        assertTrue(exception.getMessage().contains("Error: expecting two arguments, but got less than two arguments"));
    }

    @Test
    public void testPlusOK() throws IllegalArgumentException {
        Assert.assertEquals(22.0, evaluateRPN("20 2 +"), 0.0);
    }

    @Test
    public void testPlusTooManyValues() throws IllegalArgumentException {
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            evaluateRPN("20 2 + 3");
        });
        assertTrue(exception.getMessage().contains("Error: Too many values in the stack"));
    }

    @Test
    public void testPlusUnknownOperator() throws IllegalArgumentException {
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            evaluateRPN("20 2 )");
        });
        assertTrue(exception.getMessage().contains("Error: Unknown operator )"));
    }

    @Test
    public void testMinusOK() throws IllegalArgumentException {
        Assert.assertEquals(18.0, evaluateRPN("20 2 -"), 0.0);
    }

    @Test
    public void testMultiplicationOK() throws IllegalArgumentException {
        Assert.assertEquals(40.0, evaluateRPN("20 2 *"), 0.0);
    }

    @Test
    public void testMaxOK() throws IllegalArgumentException {
        Assert.assertEquals(30.0, evaluateRPN("20 2 8 7 30 12 max"), 0.0);
    }

    @Test
    public void testDivOK() throws IllegalArgumentException {
        Assert.assertEquals(10.0, evaluateRPN("20 2 /"), 0.0);
    }

    @Test
    public void testDivOK2() throws IllegalArgumentException {
        Assert.assertEquals(7.0, evaluateRPN("20 3 /"), 0.5);
    }

    @Test
    public void testDivFailWith0() throws IllegalArgumentException {
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            evaluateRPN("15 0 /");
        });
        assertTrue(exception.getMessage().contains("Error: Illegal operation"));
    }

}
