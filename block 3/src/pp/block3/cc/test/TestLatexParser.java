package pp.block3.cc.test;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import pp.block3.cc.tabular.TexLexer;
import pp.block3.cc.tabular.TexParser;
import pp.block3.cc.tabular.MyListener;

import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class TestLatexParser {

    @Test
    public void test(){
        text_test("test",false);
        file_test("./src/pp/block3/cc/tabular/tabular-1.tex",true);
        file_test("./src/pp/block3/cc/tabular/tabular-2.tex",true);
        file_test("./src/pp/block3/cc/tabular/tabular-3.tex",true);
        file_test("./src/pp/block3/cc/tabular/tabular-4.tex",false);
    }

    public void text_test(String text, boolean succeeds) {
        char_stream_test(new ANTLRInputStream(text), succeeds);
    }

    public void file_test(String filename, boolean succeeds){
        System.out.println(filename);
        try {
            char_stream_test(new ANTLRFileStream(filename), succeeds);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void char_stream_test(CharStream chars, boolean succeeds) {
        MyListener myListenerLexer = new MyListener();
        MyListener myListenerParser = new MyListener();
        Lexer lexer = new TexLexer(chars);
        lexer.removeErrorListeners();
        lexer.addErrorListener(myListenerLexer);
        TokenStream tokens = new CommonTokenStream(lexer);
        TexParser parser = new TexParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(myListenerParser);
        ParseTree pt = parser.table();
        assertEquals("Lexer: "+myListenerLexer.getErrors().toString()+" Parser: "+myListenerParser.getErrors().toString(),succeeds,myListenerLexer.getErrors().isEmpty()&&myListenerParser.getErrors().isEmpty());
    }
}
