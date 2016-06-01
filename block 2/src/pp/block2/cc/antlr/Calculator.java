package pp.block2.cc.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import java.util.List;
import java.lang.Math;

public class Calculator extends CalcBaseVisitor<Integer> {

    public static void main(String[] mainargs) {
        String expr = "(-2)^(2*(1+1))^2";

        // Convert the input text to a character stream
        CharStream stream = new ANTLRInputStream(expr);
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

        System.out.println(result);
    }

    @Override
    public Integer visitExpr(CalcParser.ExprContext ctx) {
        return visit(ctx.addition());
    }

    @Override
    public Integer visitAddition(CalcParser.AdditionContext ctx) {
        List<ParseTree> children = ctx.children;
        Integer current = visit(ctx.children.get(0));

        for(int i = 1; i < children.size(); i = i + 2) {
            String op = children.get(i).getText();
            Integer n2 = visit(children.get(i + 1));

            if (op.equals("-")) {
                current = current - n2;
            } else if (op.equals("+")) {
                current += n2;
            }

        }

        return current;
    }

    @Override
    public Integer visitMultiplication(CalcParser.MultiplicationContext ctx) {
        List<ParseTree> children = ctx.children;
        Integer current = visit(ctx.children.get(0));

        for(int i = 1; i < children.size(); i = i + 2) {
            String op = children.get(i).getText();
            Integer n2 = visit(children.get(i + 1));

            if (op.equals("*")) {
                current = current * n2;
            }

        }

        return current;
    }

    @Override
    public Integer visitNegation(CalcParser.NegationContext ctx) {
        Integer result;
        Integer size = ctx.children.size();
        Integer current = visit(ctx.children.get(size-1));
        if (size % 2 == 0){
//            odd number of negations
            result = - current;
        }
        else {
            result = current;
        }

        return result;
    }

    @Override
    public Integer visitPower(CalcParser.PowerContext ctx) {
        List<ParseTree> children = ctx.children;
        Integer size = children.size();
        Integer current = visit(ctx.children.get(size-1));

        for(int i = size-2; i >= 0; i = i - 2) {
            Integer n2 = visit(children.get(i-1));
            String op = children.get(i).getText();

            if (op.equals("^")) {
                current = (int) Math.round(Math.pow((double) n2, (double) current));
            }

        }



        return current;
    }

    @Override
    public Integer visitBase(CalcParser.BaseContext ctx) {
        List<ParseTree> children = ctx.children;
        Integer size = children.size();
        int result;

        if (size == 1){
            result = Integer.parseInt(children.get(0).getText());
        }
        else {
            result = visit(children.get(1));
        }
        return result;
    }

    @Override
    public Integer visitPo(CalcParser.PoContext ctx) {
        return visitChildren(ctx);
    }
}
