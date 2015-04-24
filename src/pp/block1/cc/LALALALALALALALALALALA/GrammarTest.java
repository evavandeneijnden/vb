package pp.block1.cc.LALALALALALALALALALALA;

import org.junit.Test;
import pp.block1.cc.antlr.LexerTester;

/**
 * Created by antoine on 24/04/15.
 */
public class GrammarTest {
    private static LexerTester tester = new LexerTester(pp.block1.cc.LALALALALALALALALALALA.Grammar.class);

    @Test
    public void succeedingTest() {
        tester.correct("");
        tester.correct("Laa");
        tester.correct("LaaLaaaa");
        tester.correct("Laa Laaaa LaLi");
        tester.correct("Laa Laaaa LaLi                          ");
        tester.wrong("\"herlgehbl\"\"a;jasjklgehu\"");
        tester.wrong("LaaaLi Laa");
        tester.wrong("LaaaaLaLaLii");
        tester.yields("Laaa   ", Grammar.LA);

    }
}
