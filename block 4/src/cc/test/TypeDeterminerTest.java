
/**
 * Created by Eva on 13/05/2015.
 */
package cc.test;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import cc.antlr.CC5.*;
import cc.antlr.Type;

import static org.junit.Assert.assertEquals;

public class TypeDeterminerTest {

    @Test
    public void testHat(){
        test(cc.antlr.Type.NUM, "1^1");
        test(cc.antlr.Type.ERR, "1^true");
        test(cc.antlr.Type.ERR, "1^bla");
        test(cc.antlr.Type.ERR, "false^2");
        test(cc.antlr.Type.ERR, "true^true");
        test(cc.antlr.Type.ERR, "false^blabla");
        test(cc.antlr.Type.STR, "lala^3");
        test(cc.antlr.Type.ERR, "lala^false");
        test(cc.antlr.Type.ERR, "lala^blabla");

    }
    @Test
    public void testPlus(){
        test(cc.antlr.Type.NUM, "1+1");
        test(cc.antlr.Type.ERR, "1+true");
        test(cc.antlr.Type.ERR, "1+bla");
        test(cc.antlr.Type.ERR, "false+2");
        test(cc.antlr.Type.BOOL, "true+true");
        test(cc.antlr.Type.ERR, "false+blabla");
        test(cc.antlr.Type.ERR, "lala+3");
        test(cc.antlr.Type.ERR, "lala+false");
        test(cc.antlr.Type.STR, "lala+blabla");
    }
    @Test
    public void testEquals(){
        test(cc.antlr.Type.BOOL, "1==1");
        test(cc.antlr.Type.ERR, "1==true");
        test(cc.antlr.Type.ERR, "1==bla");
        test(cc.antlr.Type.ERR, "false==2");
        test(cc.antlr.Type.BOOL, "true==true");
        test(cc.antlr.Type.ERR, "false==blabla");
        test(cc.antlr.Type.ERR, "lala==3");
        test(cc.antlr.Type.ERR, "lala==false");
        test(cc.antlr.Type.BOOL, "lala==blabla");

    }

    public cc.antlr.Type convertType(cc.antlr.Type type) {
        cc.antlr.Type result;

        switch(type) {
            case NUM:
                result = Type.NUM;
                break;
            case ERR:
                result = Type.ERR;
                break;
            case BOOL:
                result = Type.BOOL;
                break;
            case STR:
                result = Type.STR;
                break;
            default:
                result = Type.ERR;
        }

        return result;
    }

    public void test(cc.antlr.Type expected, String expression){
        assertEquals(expected, testCC5Attr(expression));

        ParseTree tree = testCC5(expression);
        ParseTreeWalker walker = new ParseTreeWalker();
        TypeDeterminer typeDeterminer = new TypeDeterminer();
        typeDeterminer.init();
        walker.walk(typeDeterminer, tree);
        assertEquals(expected, typeDeterminer.vals.get(tree));
    }


    private cc.antlr.Type testCC5Attr(String expression){
        CharStream chars = new ANTLRInputStream(expression);
        Lexer lexer = new CC5AttrLexer(chars);
        TokenStream tokens = new CommonTokenStream(lexer);
        CC5AttrParser parser = new CC5AttrParser(tokens);
        return parser.term().type;
    }
    private ParseTree testCC5(String expression) {
        CharStream chars = new ANTLRInputStream(expression);
        Lexer lexer = new CC5Lexer(chars);
        TokenStream tokens = new CommonTokenStream(lexer);
        CC5Parser parser = new CC5Parser(tokens);
        return parser.term();

    }
}
