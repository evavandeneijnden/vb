package pp.block6.cc;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import pp.block6.cc.pascal.FuncPascal6Lexer;
import pp.block6.cc.pascal.FuncPascal6Parser;
import pp.iloc.Simulator;
import pp.iloc.model.Program;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FuncPascalCompiler {
	/** The singleton instance of this class. */
	private final static FuncPascalCompiler instance = new FuncPascalCompiler();
	/** Debug flag. */
	private final static boolean SHOW = true;

	/** Returns the singleton instance of this class. */
	public static FuncPascalCompiler instance() {
		return instance;
	}

	/** Compiles and runs the program named in the argument. */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: filename");
			return;
		}
		try {
			System.out.println("--- Running " + args[0]);
			Program prog = instance().compile(new File(args[0]));
			if (SHOW) {
				System.out.println(prog.prettyPrint());
			}
			Simulator sim = new Simulator(prog);
			sim.run();
			System.out.println("--- Done with " + args[0]);
		} catch (ParseException exc) {
			exc.print();
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}

	/** The fixed checker of this compiler. */
	private final Checker checker;
	/** The fixed generator of this compiler. */
	private final Generator generator;

	private FuncPascalCompiler() {
		this.checker = new Checker();
		this.generator = new Generator();
	}

	/** Typechecks a given Simple Pascal string. */
	public PassOneResult check(String text) throws ParseException {
		return check(parse(text));
	}

	/** Typechecks a given Simple Pascal file. */
	public PassOneResult check(File file) throws ParseException, IOException {
		return check(parse(file));
	}

	/** Typechecks a given Simple Pascal parse tree. */
	public PassOneResult check(ParseTree tree) throws ParseException {
		return this.checker.check(tree);
	}

	/** Compiles a given Simple Pascal string into an ILOC program. */
	public Program compile(String text) throws ParseException {
		return compile(parse(text));
	}

	/** Compiles a given Simple Pascal file into an ILOC program. */
	public Program compile(File file) throws ParseException, IOException {
		return compile(parse(file));
	}

	/** Compiles a given Simple Pascal parse tree into an ILOC program. */
	public Program compile(ParseTree tree) throws ParseException {
		PassOneResult checkPassOneResult = this.checker.check(tree);
		return this.generator.generate(tree, checkPassOneResult);
	}

	/** Compiles a given Simple Pascal string into a parse tree. */
	public ParseTree parse(String text) throws ParseException {
		return parse(new ANTLRInputStream(text));
	}

	/** Compiles a given Simple Pascal string into a parse tree. */
	public ParseTree parse(File file) throws ParseException, IOException {
		return parse(new ANTLRInputStream(new FileReader(file)));
	}

	private ParseTree parse(CharStream chars) throws ParseException {
		ErrorListener listener = new ErrorListener();
		Lexer lexer = new FuncPascal6Lexer(chars);
		lexer.removeErrorListeners();
		lexer.addErrorListener(listener);
		TokenStream tokens = new CommonTokenStream(lexer);
		FuncPascal6Parser parser = new FuncPascal6Parser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(listener);
		ParseTree result = parser.program();
		listener.throwException();
		return result;
	}
}
