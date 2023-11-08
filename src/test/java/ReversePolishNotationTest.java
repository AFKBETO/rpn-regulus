import static org.example.ReversePolishNotation.evaluateRPN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class ReversePolishNotationTest {

    @Test
    public void testSqrt() throws IllegalArgumentException {
        Assert.assertEquals(3.0, evaluateRPN("9 sqrt"), 0.0);
    }

    @Test
    public void testPlusLessArg() throws IllegalArgumentException {
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {evaluateRPN("3 +");});
        assertTrue(exception.getMessage().contains("Error: expecting two arguments, but got less than two arguments"));
    }



}
