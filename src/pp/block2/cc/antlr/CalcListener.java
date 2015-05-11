// Generated from C:/Users/Eva/Documents/vb/src/pp/block2/cc/antlr\Calc.g4 by ANTLR 4.5
package pp.block2.cc.antlr;
import org.antlr.v4.runtime.misc.NotNull;
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
	void enterExpr(@NotNull CalcParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull CalcParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#addition}.
	 * @param ctx the parse tree
	 */
	void enterAddition(@NotNull CalcParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#addition}.
	 * @param ctx the parse tree
	 */
	void exitAddition(@NotNull CalcParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#multiplication}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(@NotNull CalcParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#multiplication}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(@NotNull CalcParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#negation}.
	 * @param ctx the parse tree
	 */
	void enterNegation(@NotNull CalcParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#negation}.
	 * @param ctx the parse tree
	 */
	void exitNegation(@NotNull CalcParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#power}.
	 * @param ctx the parse tree
	 */
	void enterPower(@NotNull CalcParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#power}.
	 * @param ctx the parse tree
	 */
	void exitPower(@NotNull CalcParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#base}.
	 * @param ctx the parse tree
	 */
	void enterBase(@NotNull CalcParser.BaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#base}.
	 * @param ctx the parse tree
	 */
	void exitBase(@NotNull CalcParser.BaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#po}.
	 * @param ctx the parse tree
	 */
	void enterPo(@NotNull CalcParser.PoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#po}.
	 * @param ctx the parse tree
	 */
	void exitPo(@NotNull CalcParser.PoContext ctx);
}