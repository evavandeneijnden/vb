package pp.block3.cc.test;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import pp.block3.cc.symbol.DeclUseLexer;
import pp.block3.cc.symbol.DeclUseParser;
import pp.block3.cc.symbol.ScopeParser;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by antoine on 13/05/15.
 */
public class ScopeParserTest {

    @Test
    public void test(){
        assertTrue(text_test("(D:aa U:aa U:aa)").isEmpty());
        assertTrue(text_test("(D:aa)").isEmpty());
        assertTrue(text_test("(D:aa (D:aa))").isEmpty());
        assertTrue(text_test("((D:aa) (D:aa))").isEmpty());
        assertTrue(text_test("((D:aa) D:aa)").isEmpty());
        assertTrue(text_test("()").isEmpty());
        assertEquals(2,text_test("(U:aa D:aa D:aa)").size());
        assertEquals(1,text_test("((U:aa D:aa) D:aa)").size());
        assertEquals(1,text_test("(((D:aa D:aa)))").size());
        assertEquals(1,text_test("((D:aa) U:aa)").size());
    }

    public List<String> text_test(String text) {
        CharStream chars = new ANTLRInputStream(text);
        Lexer lexer = new DeclUseLexer(chars);
        TokenStream tokens = new CommonTokenStream(lexer);
        DeclUseParser parser = new DeclUseParser(tokens);
        ParseTree parseTree = parser.program();
        ScopeParser scopeParser = new ScopeParser();
        new ParseTreeWalker().walk(scopeParser, parseTree);
        return scopeParser.getErrors();
    }
}
