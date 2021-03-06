package pp.block6.cc;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import pp.block6.cc.func.Type;
import pp.block6.cc.pascal.FuncPascal6BaseListener;
import pp.block6.cc.pascal.FuncPascal6Parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to type check and calculate flow entries and variable offsets.
 */
public class Checker extends FuncPascal6BaseListener {
    /**
     * Result of the latest call of {@link #check}.
     */
    private PassOneResult passOneResult;
    /**
     * Variable scope for the latest call of {@link #check}.
     */
    private Scope scope;
    /**
     * List of errors collected in the latest call of {@link #check}.
     */
    private List<String> errors;

    /**
     * Runs this checker on a given parse tree,
     * and returns the checker result.
     *
     * @throws ParseException if an error was found during checking.
     */
    public PassOneResult check(ParseTree tree) throws ParseException {
        this.scope = new Scope();
        this.passOneResult = new PassOneResult();
        this.errors = new ArrayList<>();
        new ParseTreeWalker().walk(this, tree);
        if (hasErrors()) {
            throw new ParseException(getErrors());
        }
        return this.passOneResult;
    }

    // Override the listener methods for the statement nodes
    @Override
    public void exitBoolExpr(FuncPascal6Parser.BoolExprContext ctx) {
        checkType(ctx.expr(0), Type.BOOL);
        checkType(ctx.expr(1), Type.BOOL);
        setType(ctx, Type.BOOL);
        setEntry(ctx, entry(ctx.expr(0)));
    }

    @Override
    public void exitCompExpr(FuncPascal6Parser.CompExprContext ctx) {
        checkType(ctx.expr(0), Type.INT);
        checkType(ctx.expr(1), Type.INT);
        setType(ctx, Type.BOOL);
        setEntry(ctx, entry(ctx.expr(0)));
    }

    @Override
    public void exitFalseExpr(FuncPascal6Parser.FalseExprContext ctx) {
        setType(ctx, Type.BOOL);
        setEntry(ctx, ctx);
    }

    @Override
    public void exitIdExpr(FuncPascal6Parser.IdExprContext ctx) {
        String id = ctx.ID().getText();
        Type type = this.scope.type(id);
        if (type == null) {
            addError(ctx, "Variable '%s' not declared", id);
        } else {
            setType(ctx, type);
            setOffset(ctx, this.scope.offset(id));
            setEntry(ctx, ctx);
        }
    }

    @Override
    public void exitMultExpr(FuncPascal6Parser.MultExprContext ctx) {
        checkType(ctx.expr(0), Type.INT);
        checkType(ctx.expr(1), Type.INT);
        setType(ctx, Type.INT);
        setEntry(ctx, entry(ctx.expr(0)));
    }

    @Override
    public void exitNumExpr(FuncPascal6Parser.NumExprContext ctx) {
        setType(ctx, Type.INT);
        setEntry(ctx, ctx);
    }

    @Override
    public void exitParExpr(FuncPascal6Parser.ParExprContext ctx) {
        setType(ctx, getType(ctx.expr()));
        setEntry(ctx, entry(ctx.expr()));
    }

    @Override
    public void exitPlusExpr(FuncPascal6Parser.PlusExprContext ctx) {
        checkType(ctx.expr(0), Type.INT);
        checkType(ctx.expr(1), Type.INT);
        setType(ctx, Type.INT);
        setEntry(ctx, entry(ctx.expr(0)));
    }

    @Override
    public void exitPrfExpr(FuncPascal6Parser.PrfExprContext ctx) {
        Type type;
        if (ctx.prfOp().MINUS() != null) {
            type = Type.INT;
        } else {
            assert ctx.prfOp().NOT() != null;
            type = Type.BOOL;
        }
        checkType(ctx.expr(), type);
        setType(ctx, type);
        setEntry(ctx, entry(ctx.expr()));
    }

    @Override
    public void exitTrueExpr(FuncPascal6Parser.TrueExprContext ctx) {
        setType(ctx, Type.BOOL);
        setEntry(ctx, ctx);
    }

    @Override
    public void exitIntType(@NotNull FuncPascal6Parser.IntTypeContext ctx) {
        setType(ctx, Type.INT);
        setEntry(ctx, ctx);
    }

    @Override
    public void exitBoolType(@NotNull FuncPascal6Parser.BoolTypeContext ctx) {
        setType(ctx, Type.BOOL);
        setEntry(ctx, ctx);
    }

    @Override
    public void exitVarDecl(@NotNull FuncPascal6Parser.VarDeclContext ctx) {
        setEntry(ctx, ctx);
    }

    @Override
    public void exitVar(@NotNull FuncPascal6Parser.VarContext ctx) {
        setEntry(ctx, ctx);
        setType(ctx, getType(ctx.type()));
        for (TerminalNode id : ctx.ID()) {
            if (this.scope.put(id.getText(), getType(ctx.type()))) {
                setOffset(id, this.scope.offset(id.getText()));
            } else {
                addError(ctx, "This variable has already been declared");
            }
        }
    }

    @Override
    public void exitIdTarget(@NotNull FuncPascal6Parser.IdTargetContext ctx) {
        setType(ctx,this.scope.type(ctx.ID().getText()));
        setOffset(ctx,this.scope.offset(ctx.ID().getText()));
        setEntry(ctx,ctx);
    }

    @Override
    public void exitAssStat(@NotNull FuncPascal6Parser.AssStatContext ctx) {
        Type var_type = getType(ctx.target());
        checkType(ctx.expr(), var_type);
        setType(ctx, var_type);
        setType(ctx.target(), var_type);
        setEntry(ctx, entry(ctx.expr()));
        setOffset(ctx, this.scope.offset(ctx.target().getText()));
    }

    @Override
    public void exitIfStat(@NotNull FuncPascal6Parser.IfStatContext ctx) {
        checkType(ctx.expr(), Type.BOOL);
        for (ParserRuleContext temp : ctx.stat()) {
            setEntry(ctx, temp);
        }
    }

    @Override
    public void exitWhileStat(@NotNull FuncPascal6Parser.WhileStatContext ctx) {
        checkType(ctx.expr(), Type.BOOL);
        setEntry(ctx, ctx.stat());
    }

    @Override
    public void exitBlockStat(@NotNull FuncPascal6Parser.BlockStatContext ctx) {
        setEntry(ctx, entry(ctx.block()));
    }

    @Override
    public void exitBlock(@NotNull FuncPascal6Parser.BlockContext ctx) {
        setEntry(ctx, entry(ctx.stat(0)));
    }

    @Override
    public void exitInStat(@NotNull FuncPascal6Parser.InStatContext ctx) {
        setEntry(ctx, ctx);
        if (this.scope.contains(ctx.target().getText())) {
            setOffset(ctx, this.scope.offset(ctx.target().getText()));
        } else {
            addError(ctx, "Variable used in IN statment undefined");
        }
    }

    @Override
    public void exitOutStat(@NotNull FuncPascal6Parser.OutStatContext ctx) {
        setEntry(ctx, ctx);
    }

    @Override
    public void exitBody(@NotNull FuncPascal6Parser.BodyContext ctx) {
        setEntry(ctx, ctx);
    }

    /**
     * Indicates if any errors were encountered in this tree listener.
     */
    public boolean hasErrors() {
        return !getErrors().isEmpty();
    }

    /**
     * Returns the list of errors collected in this tree listener.
     */
    public List<String> getErrors() {
        return this.errors;
    }

    /**
     * Checks the inferred type of a given parse tree,
     * and adds an error if it does not correspond to the expected type.
     */
    private void checkType(ParserRuleContext node, Type expected) {
        Type actual = getType(node);
        if (actual == null) {
            throw new IllegalArgumentException("Missing inferred type of "
                    + node.getText());
        }
        if (!actual.equals(expected)) {
            addError(node, "Expected type '%s' but found '%s'", expected,
                    actual);
        }
    }

    /**
     * Records an error at a given parse tree node.
     *
     * @param node    the parse tree node at which the error occurred
     * @param message the error message
     * @param args    arguments for the message, see {@link String#format}
     */
    private void addError(ParserRuleContext node, String message,
                          Object... args) {
        addError(node.getStart(), message, args);
    }

    /**
     * Records an error at a given token.
     *
     * @param token   the token at which the error occurred
     * @param message the error message
     * @param args    arguments for the message, see {@link String#format}
     */
    private void addError(Token token, String message, Object... args) {
        int line = token.getLine();
        int column = token.getCharPositionInLine();
        message = String.format(message, args);
        message = String.format("Line %d:%d - %s", line, column, message);
        this.errors.add(message);
    }

    /**
     * Convenience method to add an offset to the result.
     */
    private void setOffset(ParseTree node, Integer offset) {
        this.passOneResult.setOffset(node, offset);
    }

    /**
     * Convenience method to add a type to the result.
     */
    private void setType(ParseTree node, Type type) {
        this.passOneResult.setType(node, type);
    }

    /**
     * Returns the type of a given expression or type node.
     */
    private Type getType(ParseTree node) {
        return this.passOneResult.getType(node);
    }

    /**
     * Convenience method to add a flow graph entry to the result.
     */
    private void setEntry(ParseTree node, ParserRuleContext entry) {
        if (entry == null) {
            throw new IllegalArgumentException("Null flow graph entry");
        }
        this.passOneResult.setEntry(node, entry);
    }

    /**
     * Returns the flow graph entry of a given expression or statement.
     */
    private ParserRuleContext entry(ParseTree node) {
        return this.passOneResult.getEntry(node);
    }
}
