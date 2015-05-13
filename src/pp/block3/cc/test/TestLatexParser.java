package pp.block3.cc.test;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import pp.block3.cc.symbol.TexBaseListener;
import pp.block3.cc.symbol.TexLexer;
import pp.block3.cc.symbol.TexParser;
import pp.block3.cc.tabular.MyTexParser;

import java.io.IOException;

/**
 * Created by antoine on 13/05/15.
 */
public class TestLatexParser {

    @Test
    public void test(){
//        text_test("test");
        file_test("./src/pp/block3/cc/tabular/tabular-1.tex");
//        file_test("./src/pp/block3/cc/tabular/tabular-2.tex");
//        file_test("./src/pp/block3/cc/tabular/tabular-3.tex");
    }

    public void text_test(String text) {
        char_stream_test(new ANTLRInputStream(text));
    }

    public void file_test(String filename){
        try {
            char_stream_test(new ANTLRFileStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void char_stream_test(CharStream chars) {
        Lexer lexer = new TexLexer(chars);
        TokenStream tokens = new CommonTokenStream(lexer);
        TexParser parser = new TexParser(tokens);
        ParseTree parseTree = parser.table();
        TexBaseListener scopeParser = new MyTexParser();
        new ParseTreeWalker().walk(scopeParser, parseTree);
    }
}
