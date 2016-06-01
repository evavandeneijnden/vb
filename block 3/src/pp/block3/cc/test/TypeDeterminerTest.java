
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
        test(pp.block3.cc.antlr.CC5.Type.NUM, "1^1");
        test(pp.block3.cc.antlr.CC5.Type.ERR, "1^true");
        test(pp.block3.cc.antlr.CC5.Type.ERR, "1^bla");
        test(pp.block3.cc.antlr.CC5.Type.ERR, "false^2");
        test(pp.block3.cc.antlr.CC5.Type.ERR, "true^true");
        test(pp.block3.cc.antlr.CC5.Type.ERR, "false^blabla");
        test(pp.block3.cc.antlr.CC5.Type.STR, "lala^3");
        test(pp.block3.cc.antlr.CC5.Type.ERR, "lala^false");
        test(pp.block3.cc.antlr.CC5.Type.ERR, "lala^blabla");

    }
    @Test
    public void testPlus(){
        test(pp.block3.cc.antlr.CC5.Type.NUM, "1+1");
        test(pp.block3.cc.antlr.CC5.Type.ERR, "1+true");
        test(pp.block3.cc.antlr.CC5.Type.ERR, "1+bla");
        test(pp.block3.cc.antlr.CC5.Type.ERR, "false+2");
        test(pp.block3.cc.antlr.CC5.Type.BOOL, "true+true");
        test(pp.block3.cc.antlr.CC5.Type.ERR, "false+blabla");
        test(pp.block3.cc.antlr.CC5.Type.ERR, "lala+3");
        test(pp.block3.cc.antlr.CC5.Type.ERR, "lala+false");
        test(pp.block3.cc.antlr.CC5.Type.STR, "lala+blabla");
    }
    @Test
    public void testEquals(){
        test(pp.block3.cc.antlr.CC5.Type.BOOL, "1==1");
        test(pp.block3.cc.antlr.CC5.Type.ERR, "1==true");
        test(pp.block3.cc.antlr.CC5.Type.ERR, "1==bla");
        test(pp.block3.cc.antlr.CC5.Type.ERR, "false==2");
        test(pp.block3.cc.antlr.CC5.Type.BOOL, "true==true");
        test(pp.block3.cc.antlr.CC5.Type.ERR, "false==blabla");
        test(pp.block3.cc.antlr.CC5.Type.ERR, "lala==3");
        test(pp.block3.cc.antlr.CC5.Type.ERR, "lala==false");
        test(pp.block3.cc.antlr.CC5.Type.BOOL, "lala==blabla");

    }

    public pp.block3.cc.antlr.Type convertType(pp.block3.cc.antlr.CC5.Type type) {
        pp.block3.cc.antlr.Type result;

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

    public void test(pp.block3.cc.antlr.CC5.Type expected, String expression){
        assertEquals(expected, testCC5Attr(expression));

        ParseTree tree = testCC5(expression);
        ParseTreeWalker walker = new ParseTreeWalker();
        TypeDeterminer typeDeterminer = new TypeDeterminer();
        typeDeterminer.init();
        walker.walk(typeDeterminer, tree);
        assertEquals(convertType(expected), typeDeterminer.vals.get(tree));
    }


    private pp.block3.cc.antlr.CC5.Type testCC5Attr(String expression){
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
