package pp.block1.cc.PL;

import org.junit.Test;
import pp.block1.cc.antlr.LexerTester;

/**
 * Created by antoine on 24/04/15.
 */
public class GrammarTest {
    private static LexerTester tester = new LexerTester(pp.block1.cc.PL.Grammar.class);

    @Test
    public void succeedingTest() {
        tester.correct("");
        tester.correct("\"ABCDEF\"");
        tester.correct("\"\"");
        tester.correct("\"\"\"\"");
        tester.correct("\"herlgehbl\"\"a;jasjklgehu\"");
        tester.wrong("\"\"\"");
        tester.wrong("\"\" \"\"");
        tester.wrong("\"");
        tester.wrong("\"asdfasdfl;kj");

    }
}
