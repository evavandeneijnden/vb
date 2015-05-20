package pp.s1378791.q1_2;

import pp.block1.cc.antlr.LexerTester;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by antoine on 19/05/15.
 */
public class NumbersTest {
    LexerTester tester;

    @Before
    public void setUp() {
        tester = new LexerTester(Numbers.class);
    }

    @Test
    public void testIntBinary() {
        tester.yields("0b0010100", Numbers.INT_BINARY);
        tester.yields("0b10101000", Numbers.INT_BINARY);

        tester.wrong("0b200");
        tester.wrong("0ba11");
    }

    @Test
    public void testIntOctal() {
        tester.yields("00", Numbers.INT_OCTAL);
        tester.yields("0125546347123445", Numbers.INT_OCTAL);
        tester.yields("05234546234", Numbers.INT_OCTAL);

        tester.yields("08143",Numbers.INT_DECIMAL,Numbers.INT_DECIMAL);
    }

    @Test
    public void testIntDecimal() {
        tester.yields("0", Numbers.INT_DECIMAL);
        tester.yields("1234", Numbers.INT_DECIMAL);

        tester.wrong("a");
    }

    @Test
    public void testIntHexadecimal() {
        tester.yields("0x00000", Numbers.INT_HEXADECIMAL);
        tester.yields("0x01234567890abcdefABCDEF", Numbers.INT_HEXADECIMAL);
        tester.yields("0x0", Numbers.INT_HEXADECIMAL);

        tester.wrong("0xdfg11");
    }

    @Test
    public void testLong(){
        tester.wrong("0b0100lL");
        tester.wrong("0b0100Ll");
        tester.wrong("0b0100LL");

        tester.wrong("0125546347123445ll");

        tester.wrong("1234ll");

        tester.wrong("0x01234567890abcdefABCDEFll");

    }

    @Test
    public void testLongBinary() {
        tester.yields("0b0010100l", Numbers.LONG_BINARY);
        tester.yields("0b0010100L", Numbers.LONG_BINARY);
        tester.yields("0b10101000l", Numbers.LONG_BINARY);
        tester.yields("0b10101000L", Numbers.LONG_BINARY);

        tester.wrong("0b2000101l");
        tester.wrong("0b2000101L");
        tester.wrong("0b0100011a110l");
        tester.wrong("0b0100011a110L");
    }

    @Test
    public void testLongOctal() {
        tester.yields("00l", Numbers.LONG_OCTAL);
        tester.yields("00L", Numbers.LONG_OCTAL);
        tester.yields("0125546347123445l", Numbers.LONG_OCTAL);
        tester.yields("0125546347123445L", Numbers.LONG_OCTAL);
        tester.yields("05234546234L", Numbers.LONG_OCTAL);

        tester.yields("000", Numbers.INT_OCTAL, Numbers.INT_DECIMAL);
        tester.yields("08", Numbers.INT_DECIMAL, Numbers.INT_DECIMAL);
    }

    @Test
    public void testLongDecimal() {
        tester.yields("0L", Numbers.LONG_DECIMAL);
        tester.yields("1234L", Numbers.LONG_DECIMAL);

        tester.wrong("aL");
    }

    @Test
    public void testLongHexadecimal() {
        tester.yields("0x00000L", Numbers.LONG_HEXADECIMAL);
        tester.yields("0x01234567890abcdefABCDEFL", Numbers.LONG_HEXADECIMAL);
        tester.yields("0x0L", Numbers.LONG_HEXADECIMAL);

        tester.wrong("0xdfg11");
    }

}
