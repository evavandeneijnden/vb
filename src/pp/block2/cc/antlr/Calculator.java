package pp.block2.cc.antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.*;
import pp.block2.cc.ParseException;

import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by Eva on 10/05/2015.
 */
public class Calculator  extends CalcBaseListener {
    private boolean error;
    private ParseTreeProperty<BigInteger> result;
    private String text;

    public Calculator(String text) {
       this.text = text;
       error = false;
       result = new ParseTreeProperty<>();
    }

    public BigInteger calculate() throws ParseException {
        Lexer lexer = new CalcLexer(new ANTLRInputStream(text));
        CalcParser parser = new CalcParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expr();
        new ParseTreeWalker().walk(this, tree);
        if (error){
            throw new ParseException();
        }

        return result.get(tree);
    }
    @Override
    public void exitExpr(@NotNull CalcParser.ExprContext ctx){
        BigInteger res = result.get(ctx.getChild(0));
        result.put(ctx,res);
    }
    @Override
    public void exitPower(@NotNull CalcParser.PowerContext ctx) {
        int count = ctx.getChildCount();
        BigInteger res = result.get(ctx.getChild(count - 1));
        int i = count - 2;

        while(ctx.getChild(i) != null) {
            String op = ctx.getChild(i).getText();

            if (op.equals("^")) {
                res = result.get(ctx.getChild(i - 1)).pow(res.intValue());
            }

            i = i - 2;
        }

        result.put(ctx, res);
    }

    @Override
    public void exitNegation(@NotNull CalcParser.NegationContext ctx) {
        BigInteger subResult = result.get(ctx.getChild(ctx.getChildCount() - 1));

        for(int i =0; i < ctx.getChildCount() - 1; i++) {
            subResult = BigInteger.ZERO.subtract(subResult);
        }

        result.put(ctx, subResult);
    }

    @Override
    public void exitMultiplication(@NotNull CalcParser.MultiplicationContext ctx) {
        BigInteger res = result.get(ctx.getChild(0));
        int i = 2;

        while(ctx.getChild(i) != null) {
            String op = ctx.getChild(i - 1).getText();

            if (op.equals("*")) {
                res = res.multiply(result.get(ctx.getChild(i)));
            }

            i = i + 2;
        }

        result.put(ctx, res);
    }

    @Override
    public void exitAddition(@NotNull CalcParser.AdditionContext ctx) {
        BigInteger res = result.get(ctx.getChild(0));
        int i = 2;

        while(ctx.getChild(i) != null) {
            String op = ctx.getChild(i - 1).getText();

            if (op.equals("+")) {
                res = res.add(result.get(ctx.getChild(i)));
            } else if (op.equals("-")) {
                res = res.subtract(result.get(ctx.getChild(i)));
            }

            i = i + 2;
        }

        result.put(ctx, res);
    }

    @Override
    public void exitBase(@NotNull CalcParser.BaseContext ctx) {
        if(ctx.getChild(0).getText().equals("(")) {
            BigInteger res = result.get(ctx.getChild(1));
            result.put(ctx, res);
        } else {
            BigInteger res = result.get(ctx.getChild(0));
            result.put(ctx,res);
        }
    }

    @Override
    public void visitTerminal(@NotNull TerminalNode node) {
        try {
            result.put(node, new BigInteger(node.getText()));
            result.put(node.getParent(),new BigInteger(node.getText()));
        }
        catch (NumberFormatException  e){}
    }

    @Override
    public void visitErrorNode(@NotNull ErrorNode node) {
        error = true;
    }
}