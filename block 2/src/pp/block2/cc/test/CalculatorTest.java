import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import pp.block2.cc.antlr.*;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    public void run (String input, int expected_result){
        // Convert the input text to a character stream
        CharStream stream = new ANTLRInputStream(input);
        // Build a lexer on top of the character stream
        Lexer lexer = new CalcLexer(stream);
        // Extract a token stream from the lexer
        TokenStream tokens = new CommonTokenStream(lexer);
        // Build a parser instance on top of the token stream
        CalcParser parser = new CalcParser(tokens);
        // Get the parse tree by calling the start rule
        ParseTree tree = parser.expr();

        Calculator visitor = new Calculator();
        int result = visitor.visit(tree);

        assertEquals(result, expected_result);
    }
    @Test
    public void calculatorTest(){
        run("3+5", 8);
        run("(-2)^(2*(1+1))^2", 65536);
        run("-2-8", -10);
    }
}
