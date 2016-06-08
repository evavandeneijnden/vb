package pp.block6.cc;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import pp.block6.cc.pascal.FuncPascal6BaseVisitor;
import pp.block6.cc.pascal.FuncPascal6Parser;
import pp.iloc.Simulator;
import pp.iloc.model.*;

import java.util.*;

/**
 * Class to generate ILOC code for Simple Pascal.
 */
public class Generator extends FuncPascal6BaseVisitor<Op> {
    /**
     * The representation of the boolean value <code>false</code>.
     */
    public final static Num FALSE_VALUE = new Num(Simulator.FALSE);
    /**
     * The representation of the boolean value <code>true</code>.
     */
    public final static Num TRUE_VALUE = new Num(Simulator.TRUE);

    /**
     * The base register.
     */
    private Reg arp = new Reg("r_arp");

    private Reg zeroReg = new Reg("r_zero");

    /**
     * The outcome of the checker phase.
     */
    private PassOneResult passOneResult;
    /**
     * Association of statement nodes to labels.
     */
    private ParseTreeProperty<Label> labels;
    /**
     * The program being built.
     */
    private Program prog;
    /**
     * Register count, used to generate fresh registers.
     */
    private int regCount;
    /**
     * Association of expression and target nodes to registers.
     */
    private ParseTreeProperty<Reg> regs;

    private Map<Integer, OpCode> nodeOpCodeMap = new HashMap<Integer, OpCode>() {{
        put(FuncPascal6Parser.STAR, OpCode.mult);
        put(FuncPascal6Parser.SLASH, OpCode.div);
        put(FuncPascal6Parser.PLUS, OpCode.add);
        put(FuncPascal6Parser.MINUS, OpCode.sub);
        put(FuncPascal6Parser.AND, OpCode.and);
        put(FuncPascal6Parser.OR, OpCode.or);
        put(FuncPascal6Parser.LE, OpCode.cmp_LE);
        put(FuncPascal6Parser.LT, OpCode.cmp_LT);
        put(FuncPascal6Parser.GE, OpCode.cmp_GE);
        put(FuncPascal6Parser.GT, OpCode.cmp_GT);
        put(FuncPascal6Parser.EQ, OpCode.cmp_EQ);
        put(FuncPascal6Parser.NE, OpCode.cmp_NE);
    }};
    private Stack<Reg> freeRegs;

    public Stack<Reg> getFreeRegs() {
        return freeRegs;
    }

    public Program generate(ParseTree tree, PassOneResult checkPassOneResult) {
        this.prog = new Program();
        this.passOneResult = checkPassOneResult;
        this.regs = new ParseTreeProperty<>();
        this.freeRegs = new Stack<>();
        this.labels = new ParseTreeProperty<>();
        this.regCount = 0;
        emit(OpCode.loadI, new Num(0), zeroReg);
        tree.accept(this);
        System.out.println("free: " + freeRegs);
        return this.prog;
    }

    // Override the visitor methods

    /**
     * Constructs an operation from the parameters
     * and adds it to the program under construction.
     */
    private Op emit(Label label, OpCode opCode, Operand... args) {
        Op result = new Op(label, opCode, args);
        this.prog.addInstr(result);
        return result;
    }

    /**
     * Constructs an operation from the parameters
     * and adds it to the program under construction.
     */
    private Op emit(OpCode opCode, Operand... args) {
        return emit((Label) null, opCode, args);
    }

    /**
     * Looks up the label for a given parse tree node,
     * creating it if none has been created before.
     * The label is actually constructed from the entry node
     * in the flow graph, as stored in the checker result.
     */
    private Label label(ParserRuleContext node) {
        Label result = this.labels.get(node);
        if (result == null) {
            ParserRuleContext entry = this.passOneResult.getEntry(node);
            result = createLabel(entry, "n");
            this.labels.put(node, result);
        }
        return result;
    }

    /**
     * Creates a label for a given parse tree node and prefix.
     */
    private Label createLabel(ParserRuleContext node, String prefix) {
        Token token = node.getStart();
        int line = token.getLine();
        int column = token.getCharPositionInLine();
        String result = prefix + "_" + line + "_" + column;
        return new Label(result);
    }

    /**
     * Retrieves the offset of a variable node from the checker result,
     * wrapped in a {@link pp.iloc.model.Num} operand.
     */
    private Num offset(ParseTree node) {
        return new Num(this.passOneResult.getOffset(node));
    }

    /**
     * Returns a register for a given parse tree node,
     * creating a fresh register if there is none for that node.
     */
    private Reg reg(ParseTree node) {
        Reg result = this.regs.get(node);
        if (result == null) {
            if (!freeRegs.isEmpty()) {
                result = freeRegs.pop();
                this.regs.put(node, result);
            } else {
                result = new Reg("r_" + this.regCount);
                this.regs.put(node, result);
                this.regCount++;
            }
        }
        return result;
    }

    private Reg freeReg(ParseTree node) {
        Reg freedReg = this.regs.removeFrom(node);
        if (freedReg != null) {
            this.freeRegs.push(freedReg);
        } else {
            throw new RuntimeException("Can not free reg from node");
        }
        return freedReg;
    }

    private void saveFreeReg(ParseTree node) {
        Reg freedReg = this.regs.removeFrom(node);
        if (freedReg != null) {
            this.freeRegs.push(freedReg);
        }
    }

    /**
     * Assigns a register to a given parse tree node.
     */
    private void setReg(ParseTree node, Reg reg) {
        this.regs.put(node, reg);
    }

    private OpCode getOpCode(ParserRuleContext ctx) {
        OpCode result = nodeOpCodeMap.get(ctx.getStart().getType());
        if (result != null) {
            return result;
        } else {
            throw new RuntimeException("OpCode not found");
        }
    }

    @Override
    public Op visitAssStat(@NotNull FuncPascal6Parser.AssStatContext ctx) {
        Op result = visit(ctx.expr());
        emit(OpCode.storeAI, freeReg(ctx.expr()), zeroReg, new Num(passOneResult.getOffset(ctx.target())));
        return result;
    }

    @Override
    public Op visitBlock(@NotNull FuncPascal6Parser.BlockContext ctx) {
        return visitList(new ArrayList<ParseTree>(ctx.stat()));
    }

    @Override
    public Op visitBlockStat(@NotNull FuncPascal6Parser.BlockStatContext ctx) {
        return visit(ctx.block());
    }

    @Override
    public Op visitBody(@NotNull FuncPascal6Parser.BodyContext ctx) {
//        Op result = visitList(new ArrayList<ParseTree>(ctx.decl()));
//        visit(ctx.block());
//        return result;
        return visit(ctx.block());
    }

//    @Override
//    public Op visitBoolOp(@NotNull FuncPascal6Parser.BoolOpContext ctx) {
//        return emit(nodeOpCodeMap.get());
//    }

    @Override
    public Op visitBoolExpr(@NotNull FuncPascal6Parser.BoolExprContext ctx) {
        Op result = visit(ctx.expr(0));
        visit(ctx.expr(1));
        emit(getOpCode(ctx.boolOp()), freeReg(ctx.expr(0)), freeReg(ctx.expr(1)), reg(ctx));
        return result;
    }

//    @Override
//    public Op visitBoolType(@NotNull FuncPascal6Parser.BoolTypeContext ctx) {
//
//    }

    @Override
    public Op visitCompExpr(@NotNull FuncPascal6Parser.CompExprContext ctx) {
        Op result = visitList(new ArrayList<ParseTree>(ctx.expr()));
        emit(getOpCode(ctx.compOp()), freeReg(ctx.expr(0)), freeReg(ctx.expr(1)), reg(ctx));
        return result;
    }

//    @Override
//    public Op visitCompOp(@NotNull FuncPascal6Parser.CompOpContext ctx) {
//        Op result = new Op(OpCode.nop);
//
//        return result;
//    }

    @Override
    public Op visitFalseExpr(@NotNull FuncPascal6Parser.FalseExprContext ctx) {
        return emit(OpCode.loadI, FALSE_VALUE, reg(ctx));
    }

    @Override
    public Op visitIdExpr(@NotNull FuncPascal6Parser.IdExprContext ctx) {
        return emit(OpCode.loadAI, zeroReg, new Num(passOneResult.getOffset(ctx)), reg(ctx));
    }

//    @Override
//    public Op visitIdTarget(@NotNull FuncPascal6Parser.IdTargetContext ctx) {
//        Op result = new Op(OpCode.nop);
//
//        return result;
//    }

    @Override
    public Op visitIfStat(@NotNull FuncPascal6Parser.IfStatContext ctx) {
        Op result = visit(ctx.expr());

        Label if_then = createLabel(ctx.stat(0), "if_then");
        Label if_end = createLabel(ctx, "if_end");

        if (1 < ctx.stat().size()) {
            Label if_else = createLabel(ctx.stat(1), "if_else");
            emit(OpCode.cbr, freeReg(ctx.expr()), if_then, if_else);
            visit(ctx.stat(0)).setLabel(if_then);
            emit(OpCode.jumpI, if_end);
            visit(ctx.stat(1)).setLabel(if_else);
        } else {
            emit(OpCode.cbr, freeReg(ctx.expr()), if_then, if_end);
            visit(ctx.stat(0)).setLabel(if_then);
        }
        emit(if_end, OpCode.nop);
        return result;
    }

    @Override
    public Op visitInStat(@NotNull FuncPascal6Parser.InStatContext ctx) {
        String message = ctx.STR().getText();
        Op result = emit(OpCode.in, new Str(message.substring(1, message.length() - 1)), reg(ctx));
        emit(OpCode.storeAI, freeReg(ctx), zeroReg, new Num(passOneResult.getOffset(ctx.target())));
        return result;
    }

//    @Override
//    public Op visitIntType(@NotNull FuncPascal6Parser.IntTypeContext ctx) {
//        return emit(OpCode.loadI, new Num(Integer.parseInt(ctx.INTEGER().getText())));
//    }

    @Override
    public Op visitMultExpr(@NotNull FuncPascal6Parser.MultExprContext ctx) {
        Op result = visitList(new ArrayList<ParseTree>(ctx.expr()));
        emit(getOpCode(ctx.multOp()), freeReg(ctx.expr(0)), freeReg(ctx.expr(1)), reg(ctx));
        return result;
    }

//    @Override
//    public Op visitMultOp(@NotNull FuncPascal6Parser.MultOpContext ctx) {
//        Op result = new Op(OpCode.nop);
//
//        return result;
//    }

    @Override
    public Op visitNumExpr(@NotNull FuncPascal6Parser.NumExprContext ctx) {
        return emit(OpCode.loadI, new Num(Integer.parseInt(ctx.NUM().getText())), reg(ctx));
    }

    @Override
    public Op visitOutStat(@NotNull FuncPascal6Parser.OutStatContext ctx) {
        Op result = visit(ctx.expr());
        String message = ctx.STR().getText();
        emit(OpCode.out, new Str(message.substring(1, message.length() - 1)), freeReg(ctx.expr()));
        return result;
    }

    @Override
    public Op visitParExpr(@NotNull FuncPascal6Parser.ParExprContext ctx) {
        Op result = visit(ctx.expr());
        setReg(ctx, reg(ctx.expr()));
        return result;
    }

    @Override
    public Op visitPlusExpr(@NotNull FuncPascal6Parser.PlusExprContext ctx) {
        Op result = visitList(new ArrayList<ParseTree>(ctx.expr()));
        emit(getOpCode(ctx.plusOp()), freeReg(ctx.expr(0)), freeReg(ctx.expr(1)), reg(ctx));
        return result;
    }

//    @Override
//    public Op visitPlusOp(@NotNull FuncPascal6Parser.PlusOpContext ctx) {
//        Op result = new Op(OpCode.nop);
//
//        return result;
//    }

    @Override
    public Op visitPrfExpr(@NotNull FuncPascal6Parser.PrfExprContext ctx) {
        Op result = visit(ctx.expr());
        if (ctx.prfOp().MINUS() != null) {
            emit(OpCode.sub, zeroReg, freeReg(ctx.expr()), reg(ctx));
        } else {
            emit(OpCode.xorI, freeReg(ctx.expr()), TRUE_VALUE, reg(ctx));
        }
        return result;
    }

//    @Override
//    public Op visitPrfOp(@NotNull FuncPascal6Parser.PrfOpContext ctx) {
//        Op result = new Op(OpCode.nop);
//
//        return result;
//    }

    @Override
    public Op visitProgram(@NotNull FuncPascal6Parser.ProgramContext ctx) {
        return visit(ctx.body());
    }

    @Override
    public Op visitTrueExpr(@NotNull FuncPascal6Parser.TrueExprContext ctx) {
        return emit(OpCode.loadI, FALSE_VALUE, reg(ctx));
    }

//    @Override
//    public Op visitVar(@NotNull FuncPascal6Parser.VarContext ctx) {
//        Op result = new Op(OpCode.nop);
//
//        return result;
//    }
//
//    @Override
//    public Op visitVarDecl(@NotNull FuncPascal6Parser.VarDeclContext ctx) {
//        Op result = new Op(OpCode.nop);
//
//        return result;
//    }

    @Override
    public Op visitWhileStat(@NotNull FuncPascal6Parser.WhileStatContext ctx) {
        Op result = visit(ctx.expr());

        Label while_expr = createLabel(ctx.expr(), "while_expr");
        result.setLabel(while_expr);

        Label while_then = createLabel(ctx.stat(), "while_then");
        Label while_end = createLabel(ctx, "while_end");

        emit(OpCode.cbr, freeReg(ctx.expr()), while_then, while_end);
        visit(ctx.stat()).setLabel(while_then);
        emit(OpCode.jumpI, while_expr);

        emit(while_end, OpCode.nop);
        return result;
    }

    private Op visitList(List<ParseTree> treeList) {
        Iterator<ParseTree> iterator = treeList.iterator();
        Op result = visit(iterator.next());
        while (iterator.hasNext()) {
            visit(iterator.next());
        }
        return result;
    }
}
