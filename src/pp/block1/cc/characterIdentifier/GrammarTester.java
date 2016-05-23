package pp.block1.cc.characterIdentifier;

import org.junit.Test;
import pp.block1.cc.antlr.LexerTester;

/**
 * Created by Eva on 23/04/2015.
 */
public class GrammarTester {
    private static LexerTester tester = new LexerTester(Grammar.class);

    @Test
    public void succeedingTest() {
        tester.correct("A12345");
        tester.correct("ABCDEF");
        tester.correct("a12345");
        tester.correct("");
        tester.wrong("1abcde");
        tester.wrong("A123456");
        tester.wrong("A1");

    }


}

