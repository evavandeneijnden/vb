package pp.block2.cc.antlr;

/**
 * Created by Eva on 10/05/2015.
 */
import org.junit.Test;
import pp.block2.cc.ParseException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigInteger;

public class CalculatorTest {
    @Test
    public void testCalculator() {
        testNumber();
        testNegation();
        testAddition();
        testSubtraction();
        testMultiplication();
        testPower();
        testDifficult();
        testDoubleNegation();
    }
    @Test
    public void testAddition() {
        Calculator calculator = new Calculator("3+4");
        try {
            BigInteger result = calculator.calculate();
            assertEquals(new BigInteger("7"), result);
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }
    @Test
    public void testSubtraction() {
        Calculator calculator = new Calculator("5-2");
        try {
            BigInteger result = calculator.calculate();
            assertEquals(new BigInteger("3"), result);
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }
    @Test
    public void testMultiplication() {
        Calculator calculator = new Calculator("3*4");
        try {
            BigInteger result = calculator.calculate();
            assertEquals(new BigInteger("12"), result);
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }
    @Test
    public void testPower() {
        Calculator calculator = new Calculator("2^3");
        try {
            BigInteger result = calculator.calculate();
            assertEquals(new BigInteger("8"), result);
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }
    @Test
    public void testNegation() {
        Calculator calculator = new Calculator("-9");
        try {
            BigInteger result = calculator.calculate();
            assertEquals(new BigInteger("-9"), result);
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }
    @Test
    public void testNumber() {
        Calculator calculator = new Calculator("4");
        try {
            BigInteger result = calculator.calculate();
            assertEquals(new BigInteger("4"), result);
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }
    @Test
    public void testDifficult() {
        Calculator calculator = new Calculator("-((-3+4+0)^(1*4))");
        try {
            BigInteger result = calculator.calculate();
            assertEquals(new BigInteger("-1"), result);
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }
    @Test
    public void testDoubleNegation() {
        Calculator calculator = new Calculator("--2");
        try {
            BigInteger result = calculator.calculate();
            assertEquals(new BigInteger("2"), result);
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }
    @Test
    public void testMultiplePlusses() {
        Calculator calculator = new Calculator("2+2+2+2+2+2+2+2");
        try {
            BigInteger result = calculator.calculate();
            assertEquals(new BigInteger("16"), result);
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }
    @Test
    public void testMultipleTimes() {
        Calculator calculator = new Calculator("2*3*4");
        try {
            BigInteger result = calculator.calculate();
            assertEquals(new BigInteger("24"), result);
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }
    @Test
    public void testMultiplePows() {
        Calculator calculator = new Calculator("3^2^2");
        try {
            BigInteger result = calculator.calculate();
            assertEquals(new BigInteger("81"), result);
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }
}
