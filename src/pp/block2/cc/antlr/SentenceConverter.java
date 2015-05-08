package pp.block2.cc.antlr;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import pp.block2.cc.*;
import pp.block2.cc.ll.Sentence;

import java.util.Stack;

public class SentenceConverter //
        extends SentenceBaseListener implements Parser {
    public static final NonTerm SENTENCE = new NonTerm("Sentence");
    public static final NonTerm SUBJECT = new NonTerm("Subject");
    public static final NonTerm OBJECT = new NonTerm("Object");
    public static final NonTerm MODIFIER = new NonTerm("Modifier");
    /**
     * Factory needed to create terminals of the {@link Sentence}
     * grammar. See {@link pp.block2.cc.ll.SentenceParser} for
     * example usage.
     */
    private final SymbolFactory fact;
    private AST result = null;
    private Stack<AST> currentPosition;
    private boolean error;

    public SentenceConverter() {
        this.fact = new SymbolFactory(Sentence.class);
    }

    @Override
    public AST parse(Lexer lexer) throws ParseException {
        currentPosition = new Stack<>();

        error = false;
        SentenceParser parser = new SentenceParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.sentence();
        new ParseTreeWalker().walk(this, tree);
        if (error) {
            throw new ParseException();
        } else {
            return result;
        }
    }

    @Override
    public void enterSentence(@NotNull SentenceParser.SentenceContext ctx) {
        result = new AST(SENTENCE);
        currentPosition.push(result);
    }


    @Override
    public void exitSentence(@NotNull SentenceParser.SentenceContext ctx) {
        currentPosition.pop();
    }


    @Override
    public void enterSubject(@NotNull SentenceParser.SubjectContext ctx) {
        AST temp = new AST(SUBJECT);
        currentPosition.peek().addChild(temp);
        currentPosition.push(temp);
    }


    @Override
    public void exitSubject(@NotNull SentenceParser.SubjectContext ctx) {
        currentPosition.pop();
    }


    @Override
    public void enterObject(@NotNull SentenceParser.ObjectContext ctx) {
        AST temp = new AST(OBJECT);
        currentPosition.peek().addChild(temp);
        currentPosition.push(temp);
    }


    @Override
    public void exitObject(@NotNull SentenceParser.ObjectContext ctx) {
        currentPosition.pop();
    }


    @Override
    public void enterModifier(@NotNull SentenceParser.ModifierContext ctx) {
        AST temp = new AST(MODIFIER);
        currentPosition.peek().addChild(temp);
        currentPosition.push(temp);
    }


    @Override
    public void exitModifier(@NotNull SentenceParser.ModifierContext ctx) {
        currentPosition.pop();
    }


    @Override
    public void enterEveryRule(@NotNull ParserRuleContext ctx) {
    }


    @Override
    public void exitEveryRule(@NotNull ParserRuleContext ctx) {
    }


    @Override
    public void visitTerminal(@NotNull TerminalNode node) {
        currentPosition.peek().addChild(new AST(fact.getTerminal(node.getSymbol().getType()), node.getSymbol()));
    }


    @Override
    public void visitErrorNode(@NotNull ErrorNode node) {
        error = true;
    }
}
