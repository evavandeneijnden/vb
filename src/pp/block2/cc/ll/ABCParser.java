package pp.block2.cc.ll;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import pp.block2.cc.*;

import java.util.List;

import static pp.block2.cc.ll.Sentence.*;

//TODO: Parser does not seem to import the generated lexer from Antlr. You need access to R static variable
//TODO: Parser rules seem off. First terminal is ?'R'? but this is not integrated in the grammar?

public class ABCParser implements Parser {
    public ABCParser() {
        this.fact = new SymbolFactory(ABC.class);
    }

    private final SymbolFactory fact;
    private List<? extends Token> tokens;
    private int index;

    private static final NonTerm Lp = new NonTerm("L");
    private static final NonTerm Rp = new NonTerm("R");
    private static final NonTerm Pp = new NonTerm("P");
    private static final NonTerm Op = new NonTerm("O");

    @Override
    public AST parse(Lexer lexer) throws ParseException {
        this.tokens = lexer.getAllTokens();
        this.index = 0;
        return parseL();
    }

    private AST parseL() throws ParseException {
        AST result = new AST(Lp);
        Token next = peek();
        // choose between rules based on the lookahead
        switch (next.getType()) {
            case 'R':
                result.addChild(parseR());
                result.addChild(parseToken('a'));
                break;
            case 'b':
                result.addChild(parseToken('b'));
                result.addChild(parseO());
                result.addChild(parseToken('c'));
                break;
            default:
                System.out.println(next.getType());
                throw unparsable(Lp);
        }
        return result;
    }

    private AST parseR() throws ParseException {
        AST result = new AST(Rp);
        Token next = peek();
        switch(next.getType()) {
            case 'a':
                result.addChild(parseToken('a'));
                result.addChild(parseToken('b'));
                result.addChild(parseToken('a'));
                result.addChild(parseP());
                break;
            case 'c':
                result.addChild(parseToken('c'));
                result.addChild(parseToken('a'));
                result.addChild(parseToken('b'));
                result.addChild(parseToken('a'));
                result.addChild(parseP());
                break;
            default:
                throw unparsable(Rp);
        }
        return result;
    }

    private AST parseP() throws ParseException {
        AST result = new AST(Pp);
        Token next = peek();
        switch(next.getType()){
            case 'b':
                result.addChild(parseToken('b'));
                result.addChild(parseToken('c'));
                result.addChild(parseP());
                break;
        }
        return result;
    }

    private AST parseO() throws ParseException {
        AST result =  new AST(Op);
        Token next = peek();
        switch(next.getType()){
            case 'b':
                result.addChild(parseToken('b'));
                break;
        }
        return result;
    }

    private ParseException unparsable(NonTerm nt) {
        try {
            Token next = peek();
            return new ParseException(String.format(
                    "Line %d:%d - could not parse '%s' at token '%s'",
                    next.getLine(), next.getCharPositionInLine(), nt.getName(),
                    fact.get(next.getType())));
        } catch (ParseException e) {
            return e;
        }
    }

    /** Creates an AST based on the expected token type. */
    private AST parseToken(int tokenType) throws ParseException {
        Token next = next();
        if (next.getType() != tokenType) {
            throw new ParseException(String.format(
                    "Line %d:%d - expected token '%s' but found '%s'",
                    next.getLine(), next.getCharPositionInLine(),
                    fact.get(tokenType), fact.get(next.getType())));
        }
        return new AST(fact.getTerminal(tokenType), next);
    }

    /** Returns the next token, without moving the token index. */
    private Token peek() throws ParseException {
        if (index >= tokens.size()) {
            throw new ParseException("Reading beyond end of input");
        }
        return tokens.get(index);
    }

    /** Returns the next token and moves up the token index. */
    private Token next() throws ParseException {
        Token result = peek();
        index++;
        return result;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: [text]+");
        } else {
            for (String text : args) {
                CharStream stream = new ANTLRInputStream(text);
                Lexer lexer = new ABC(stream);
                try {
                    System.out.printf("Parse tree: %n%s%n",
                            new ABCParser().parse(lexer));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
