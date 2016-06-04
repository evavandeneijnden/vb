package pp.block4.cc.iloc;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.iloc.Simulator;
import pp.iloc.model.*;
import pp.iloc.parse.ErrorListener;

import java.util.HashMap;
import java.util.Map;

public class CalcCompiler extends CalcBaseListener {
    /**
     * Program under construction.
     */
    private Program prog;
    // Attribute maps and other fields

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: [expr]+");
            return;
        }
        CalcCompiler compiler = new CalcCompiler();
        for (String expr : args) {
            System.out.println("Processing " + expr);
            Program prog = compiler.compile(expr);
            new Simulator(prog).run();
            System.out.println(prog.prettyPrint());
        }
    }

    /**
     * Compiles a given expression string into an ILOC program.
     */
    public Program compile(String text) {
        Program result = null;
        ErrorListener listener = new ErrorListener();
        CharStream chars = new ANTLRInputStream(text);
        Lexer lexer = new CalcLexer(chars);
        lexer.removeErrorListeners();
        lexer.addErrorListener(listener);
        TokenStream tokens = new CommonTokenStream(lexer);
        CalcParser parser = new CalcParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(listener);
        ParseTree tree = parser.expr();
        if (listener.hasErrors()) {
            System.out.printf("Parse errors in %s:%n", text);
            for (String error : listener.getErrors()) {
                System.err.println(error);
            }
        } else {
            result = compile(tree);
        }
        return result;
    }

    /**
     * Compiles a given Calc-parse tree into an ILOC program.
     */
    public Program compile(ParseTree tree) {
        this.prog = new Program();
        MyListener temp = new MyListener();
        new ParseTreeWalker().walk(temp, tree);
        prog.addInstr(new Op(OpCode.out, new Str("Outcome: "), temp.getLastReg()));
        return prog;
    }

    /**
     * Constructs an operation from the parameters
     * and adds it to the program under construction.
     */
    private void emit(OpCode opCode, Operand... args) {
        this.prog.addInstr(new Op(opCode, args));
    }

    private class MyListener extends CalcBaseListener {
        private Map<ParseTree, Reg> registerMap;
        private Map<ParseTree, Integer> valueMap;
        private Reg lastReg;

        public MyListener() {
            registerMap = new HashMap<>();
            valueMap = new HashMap<>();
        }

        @Override
        public void exitTimes(@NotNull CalcParser.TimesContext ctx) {
            buildTimesOrAdd(OpCode.mult, OpCode.multI, ctx, ctx.expr(0), ctx.expr(1));
        }

        @Override
        public void exitPlus(@NotNull CalcParser.PlusContext ctx) {
            buildTimesOrAdd(OpCode.add, OpCode.addI, ctx, ctx.expr(0), ctx.expr(1));
        }

        private void buildTimesOrAdd(OpCode opCodeReg, OpCode opCodeConst, ParseTree ctx, ParseTree ctx_left, ParseTree ctx_right) {
            System.out.println(ctx.getText());
            System.out.println(registerMap.get(ctx));
            System.out.println(registerMap.get(ctx_left));
            System.out.println(registerMap.get(ctx_right));
            if (!registerMap.containsKey(ctx_right)) {
                if (!registerMap.containsKey(ctx_left)) {
                    buildNum(ctx_left);
                }
                prog.addInstr(new Op(opCodeConst,
                        registerMap.get(ctx_left),
                        new Num(valueMap.get(ctx_right)),
                        setNewReg(ctx)));
            } else if (!registerMap.containsKey(ctx_left)) {
                prog.addInstr(new Op(opCodeConst,
                        registerMap.get(ctx_right),
                        new Num(valueMap.get(ctx_left)),
                        setNewReg(ctx)));
            } else {
                prog.addInstr(new Op(opCodeReg,
                        registerMap.get(ctx_left),
                        registerMap.get(ctx_right),
                        setNewReg(ctx)));
            }
        }

        @Override
        public void exitMinus(@NotNull CalcParser.MinusContext ctx) {
            if (!registerMap.containsKey(ctx.expr())) {
                valueMap.put(ctx.expr(), -valueMap.get(ctx.expr()));
                buildNum(ctx);
            } else {
                prog.addInstr(new Op(OpCode.rsubI, registerMap.get(ctx.expr()), new Num(0), setNewReg(ctx)));
            }
        }

        @Override
        public void exitPar(@NotNull CalcParser.ParContext ctx) {
            registerMap.put(ctx, registerMap.get(ctx.expr()));
        }

        @Override
        public void exitNumber(@NotNull CalcParser.NumberContext ctx) {
            valueMap.put(ctx, Integer.parseInt(ctx.NUMBER().getText()));
            buildNum(ctx);
        }

        private void buildNum(ParseTree ctx) {
            prog.addInstr(new Op(OpCode.loadI, new Num(valueMap.get(ctx)), setNewReg(ctx)));
        }

        private Reg setNewReg(ParseTree ctx) {
            Reg temp = new Reg(String.format("r_%d", registerMap.keySet().size()));
            registerMap.put(ctx, temp);
            lastReg = temp;
            return temp;
        }

        public Reg getLastReg() {
            return lastReg;
        }
    }
}
