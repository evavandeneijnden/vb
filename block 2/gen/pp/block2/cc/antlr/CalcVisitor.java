// Generated from C:/Users/Eva/Documents/vb/block 2/src/pp/block2/cc/antlr\Calc.g4 by ANTLR 4.5.1
package pp.block2.cc.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(CalcParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#addition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(CalcParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#multiplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(CalcParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#negation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(CalcParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#power}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower(CalcParser.PowerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBase(CalcParser.BaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#po}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPo(CalcParser.PoContext ctx);
}