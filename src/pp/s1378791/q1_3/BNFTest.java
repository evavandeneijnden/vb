package pp.s1378791.q1_3;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by antoine on 20/05/15.
 */
public class BNFTest {
    @Test
    public void testParseTree() {
        assertEquals("(e (e (f (g (g (a a)) [ (e (e (f (g (a i)))) + (f (g (a 1)))) ]))) + (f (g (g (a b)) . field)))",
                parseStringToTree("a[i+1]+b.field"));
        assertEquals("(e (e (e (f (g (g (a ( (e (f ( Type ) (f (g (a x))))) ))) . i))) - (f (g (a 10)))) + (f (g (a y))))",
                parseStringToTree("((Type)x).i-10+y"));
    }



    public String parseStringToTree(String text) {
        CharStream stream = new ANTLRInputStream(text);
        Lexer lexer = new BNFLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        BNFParser parser = new BNFParser(tokens);
        ParseTree tree = parser.e();
        return tree.toStringTree(parser);
    }
}
