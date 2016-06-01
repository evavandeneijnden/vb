// Generated from C:/Users/Eva/Documents/vb/block 2/src/pp/block2/cc/antlr\Calc.g4 by ANTLR 4.5.1
package pp.block2.cc.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcParser}.
 */
public interface CalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CalcParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CalcParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#addition}.
	 * @param ctx the parse tree
	 */
	void enterAddition(CalcParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#addition}.
	 * @param ctx the parse tree
	 */
	void exitAddition(CalcParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#multiplication}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(CalcParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#multiplication}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(CalcParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#negation}.
	 * @param ctx the parse tree
	 */
	void enterNegation(CalcParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#negation}.
	 * @param ctx the parse tree
	 */
	void exitNegation(CalcParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#power}.
	 * @param ctx the parse tree
	 */
	void enterPower(CalcParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#power}.
	 * @param ctx the parse tree
	 */
	void exitPower(CalcParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#base}.
	 * @param ctx the parse tree
	 */
	void enterBase(CalcParser.BaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#base}.
	 * @param ctx the parse tree
	 */
	void exitBase(CalcParser.BaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#po}.
	 * @param ctx the parse tree
	 */
	void enterPo(CalcParser.PoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#po}.
	 * @param ctx the parse tree
	 */
	void exitPo(CalcParser.PoContext ctx);
}