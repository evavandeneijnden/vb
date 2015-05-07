package pp.block2.cc.ll;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import pp.block2.cc.*;

import java.util.List;

public class ABCParser implements Parser {
    private static final NonTerm L = new NonTerm("L");
    private static final NonTerm R = new NonTerm("R");
    private static final NonTerm P = new NonTerm("P");
    private static final NonTerm O = new NonTerm("O");
    private final SymbolFactory fact;
    private List<? extends Token> tokens;
    private int index;

    public ABCParser() {
        this.fact = new SymbolFactory(ABC.class);
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

    @Override
    public AST parse(Lexer lexer) throws ParseException {
        this.tokens = lexer.getAllTokens();
        this.index = 0;
        return parseL();
    }

    private AST parseL() throws ParseException {
        AST result = new AST(L);
        Token next = peek();
        switch (next.getType()) {
            case ABC.A:
            case ABC.C:
                result.addChild(parseR());
                result.addChild(parseToken(ABC.A));
                break;

            case ABC.B:
                result.addChild(parseToken(ABC.B));
                result.addChild(parseO());
                result.addChild(parseToken(ABC.C));
                break;
            default:
                throw unparsable(L);
        }
        return result;
    }

    private AST parseR() throws ParseException {
        AST result = new AST(R);
        Token next = peek();
        switch (next.getType()) {
            case ABC.A:
                result.addChild(parseToken(ABC.A));
                result.addChild(parseToken(ABC.B));
                result.addChild(parseToken(ABC.A));
                result.addChild(parseP());
                break;

            case ABC.C:
                result.addChild(parseToken(ABC.C));
                result.addChild(parseToken(ABC.A));
                result.addChild(parseToken(ABC.B));
                result.addChild(parseToken(ABC.A));
                result.addChild(parseP());
                break;
            default:
                throw unparsable(R);
        }
        return result;
    }

    private AST parseO() throws ParseException {
        AST result = new AST(O);
        Token next = peek();
        if (next.getType() == ABC.B) {
            result.addChild(parseToken(ABC.B));
        }
        return result;
    }

    private AST parseP() throws ParseException {
        AST result = new AST(P);
        Token next = peek();
        if (next.getType() == ABC.B) {
            result.addChild(parseToken(ABC.B));
            result.addChild(parseToken(ABC.C));
            result.addChild(parseP());
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

    /**
     * Returns the next token, without moving the token index.
     */
    private Token peek() throws ParseException {
        if (index >= tokens.size()) {
            throw new ParseException("Reading beyond end of input");
        }
        return tokens.get(index);
    }

    /**
     * Returns the next token and moves up the token index.
     */
    private Token next() throws ParseException {
        Token result = peek();
        index++;
        return result;
    }

    /**
     * Creates an AST based on the expected token type.
     */
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

}
