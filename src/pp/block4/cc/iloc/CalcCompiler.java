package pp.block4.cc.iloc;

//import pp.block4.cc.iloc.Simulator;
//import pp.block4.cc.iloc.model.Op;
//import pp.block4.cc.iloc.model.OpCode;
//import pp.block4.cc.iloc.model.Operand;
//import pp.block4.cc.iloc.model.Program;

public class CalcCompiler extends CalcBaseListener {
	/** Program under construction. */
//	private Program prog;
//	// Attribute maps and other fields
//
//	/** Compiles a given expression string into an ILOC program. */
//	public Program compile(String text) {
//		Program result = null;
//		ErrorListener listener = new ErrorListener();
//		CharStream chars = new ANTLRInputStream(text);
//		Lexer lexer = new CalcLexer(chars);
//		lexer.removeErrorListeners();
//		lexer.addErrorListener(listener);
//		TokenStream tokens = new CommonTokenStream(lexer);
//		CalcParser parser = new CalcParser(tokens);
//		parser.removeErrorListeners();
//		parser.addErrorListener(listener);
//		ParseTree tree = parser.expr();
//		if (listener.hasErrors()) {
//			System.out.printf("Parse errors in %s:%n", text);
//			for (String error : listener.getErrors()) {
//				System.err.println(error);
//			}
//		} else {
//			result = compile(tree);
//		}
//		return result;
//	}
//
//	/** Compiles a given Calc-parse tree into an ILOC program. */
//	public Program compile(ParseTree tree) {
//		// Fill in
//	}
//
//	/** Constructs an operation from the parameters
//	 * and adds it to the program under construction. */
//	private void emit(OpCode opCode, Operand... args) {
//		this.prog.addInstr(new Op(opCode, args));
//	}
//
//	public static void main(String[] args) {
//		if (args.length == 0) {
//			System.err.println("Usage: [expr]+");
//			return;
//		}
//		CalcCompiler compiler = new CalcCompiler();
//		for (String expr : args) {
//			System.out.println("Processing " + expr);
//			Program prog = compiler.compile(expr);
//			new Simulator(prog).run();
//			System.out.println(prog.prettyPrint());
//		}
//	}
}
