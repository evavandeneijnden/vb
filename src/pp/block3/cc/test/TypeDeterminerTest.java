package pp.block3.cc.test;

/**
 * Created by Eva on 13/05/2015.
 */
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import pp.block3.cc.antlr.CC5.*;
import pp.block3.cc.antlr.Type;

import static org.junit.Assert.assertEquals;

public class TypeDeterminerTest {

    @Test
    public void testHat(){
        test(Type.NUM, "1+1");
        test(Type.ERR, "1+true");
        test(Type.ERR, "1+bla");
        test(Type.ERR, "false+2");
        test(Type.ERR, "true+true");
        test(Type.ERR, "false+blabla");
        test(Type.STR, "lala+3");
        test(Type.ERR, "lala+false");
        test(Type.ERR, "lala+blabla");

    }
    @Test
    public void testPlus(){
        test(Type.NUM, "1+1");
        test(Type.ERR, "1+true");
        test(Type.ERR, "1+bla");
        test(Type.ERR, "false+2");
        test(Type.BOOL, "true+true");
        test(Type.ERR, "false+blabla");
        test(Type.ERR, "lala+3");
        test(Type.ERR, "lala+false");
        test(Type.STR, "lala+blabla");
    }
    @Test
    public void testEquals(){
        test(Type.BOOL, "1+1");
        test(Type.ERR, "1+true");
        test(Type.ERR, "1+bla");
        test(Type.ERR, "false+2");
        test(Type.BOOL, "true+true");
        test(Type.ERR, "false+blabla");
        test(Type.ERR, "lala+3");
        test(Type.ERR, "lala+false");
        test(Type.BOOL, "lala+blabla");

    }

    public void test(Type expected, String expression){
        assertEquals(expected, testCC5Attr(expression));
        ParseTree tree = testCC5(expression);
        ParseTreeWalker walker = new ParseTreeWalker();
        TypeDeterminer typeDeterminer = new TypeDeterminer();
        typeDeterminer.init();
        walker.walk(typeDeterminer, tree);
        assertEquals(expected, typeDeterminer.vals.get(tree));
    }


    private ParseTree testCC5Attr(String expression){
        CharStream chars = new ANTLRInputStream(expression);
        Lexer lexer = new CC5AttrLexer(chars);
        TokenStream tokens = new CommonTokenStream(lexer);
        CC5AttrParser parser = new CC5AttrParser(tokens);
        return parser.term();


    }
    private ParseTree testCC5(String expression) {
        CharStream chars = new ANTLRInputStream(expression);
        Lexer lexer = new CC5Lexer(chars);
        TokenStream tokens = new CommonTokenStream(lexer);
        CC5Parser parser = new CC5Parser(tokens);
        return parser.term();

    }
}
