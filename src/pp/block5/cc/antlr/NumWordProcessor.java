package pp.block5.cc.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import pp.block5.cc.ErrorListener;
import pp.block5.cc.ParseException;

/**
 * Prettyprints a (number, word)-sentence and sums up the numbers.
 */
public class NumWordProcessor extends NumWordBaseVisitor<Integer> {

    private String prettyText = "";
    private int total;


    public static void main(String[] args) {
        NumWordProcessor grouper = new NumWordProcessor();
        if (args.length == 0) {
            process(grouper, "10pudding");
            process(grouper, "1sock2shoes 3 holes");
            process(grouper, "3 strands 10 blocks 11 weeks 15 credits");
            process(grouper, "1 2 3");
        } else {
            for (String text : args) {
                process(grouper, text);
            }
        }
    }

    private static void process(NumWordProcessor grouper, String text) {
        try {
            System.out.printf("Processing '%s':%n", text);
            int result = grouper.group(text);
            System.out.println("Total: " + result);
        } catch (ParseException exc) {
            exc.print();
        }
    }

    /**
     * Groups a given sentence and prints it to stdout.
     * Returns the sum of the numbers in the sentence.
     */
    public int group(String text) throws ParseException {
        CharStream chars = new ANTLRInputStream(text);
        ErrorListener listener = new ErrorListener();
        Lexer lexer = new NumWordLexer(chars);
        lexer.removeErrorListeners();
        lexer.addErrorListener(listener);
        TokenStream tokens = new CommonTokenStream(lexer);
        NumWordParser parser = new NumWordParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(listener);
        ParseTree tree = parser.sentence();
        listener.throwException();
        return visit(tree);
    }

    @Override
    public Integer visitSentence(@NotNull NumWordParser.SentenceContext ctx) {
        Integer result = 0;
        prettyText = "";

        result = visit(ctx.getChild(0));
        visit(ctx.getChild(1));
        for (int i = 2; i < ctx.children.size() - 1; i += 2) {
            if (ctx.children.size() - i <= 3) {
                prettyText += " and ";
            } else {
                prettyText += ", ";
            }
            result += visit(ctx.getChild(i));
            visit(ctx.getChild(i + 1));
        }

        System.out.println(prettyText);
        return result;
    }

    @Override
    public Integer visitNumber(@NotNull NumWordParser.NumberContext ctx) {
        prettyText += ctx.NUMBER().getText() + " ";
        return new Integer(ctx.NUMBER().getText());
    }

    @Override
    public Integer visitWord(@NotNull NumWordParser.WordContext ctx) {
        prettyText += ctx.WORD().getText();
        return null;
    }


    // Override the visitor methods.
    // Each visitor method should call visit(child)
    // if and when it wants to visit that child node.

}
