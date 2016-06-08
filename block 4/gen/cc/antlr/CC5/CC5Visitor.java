// Generated from C:/Users/Eva/Documents/vb/block 4/src/cc/antlr/CC5\CC5.g4 by ANTLR 4.5.1
package cc.antlr.CC5;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CC5Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CC5Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code str}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStr(CC5Parser.StrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheses(CC5Parser.ParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(CC5Parser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code num}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(CC5Parser.NumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equals}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquals(CC5Parser.EqualsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hat}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHat(CC5Parser.HatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(CC5Parser.PlusContext ctx);
}