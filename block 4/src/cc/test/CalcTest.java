package cc.test;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import cc.antlr.*;
import cc.antlr.CalcAttrParser.ExprContext;

import static org.junit.Assert.assertEquals;

public class CalcTest {

	@Test
	public void test() {
		test(5, "3+2");
		test(7, "1+2*3");
		test(9, "(1+2)*3");
		test(-1, "1+-2");
		test(1, "-8+9");
		test(-3, "-1*3");
	}

	private void test(int expected, String expr) {
		assertEquals(expected, parseCalcAttr(expr).val);
		ParseTree tree = parseCalc(expr);
		calc.init();
		walker.walk(calc, tree);
		assertEquals(expected, calc.val(tree));
	}

	private final ParseTreeWalker walker = new ParseTreeWalker();
	private final Calculator calc = new Calculator();

	private ParseTree parseCalc(String text) {
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new CalcLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		CalcParser parser = new CalcParser(tokens);
		return parser.expr();
	}

	private ExprContext parseCalcAttr(String text) {
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new CalcAttrLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		CalcAttrParser parser = new CalcAttrParser(tokens);
		return parser.expr();
	}
}
