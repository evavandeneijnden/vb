// Generated from C:/Users/Eva/Documents/vb/src/pp/block3/cc/antlr/CC5\CC5.g4 by ANTLR 4.5
package pp.block3.cc.antlr.CC5;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CC5Parser}.
 */
public interface CC5Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code str}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterStr(@NotNull CC5Parser.StrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code str}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitStr(@NotNull CC5Parser.StrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(@NotNull CC5Parser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(@NotNull CC5Parser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterBool(@NotNull CC5Parser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitBool(@NotNull CC5Parser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code num}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterNum(@NotNull CC5Parser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code num}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitNum(@NotNull CC5Parser.NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equals}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterEquals(@NotNull CC5Parser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equals}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitEquals(@NotNull CC5Parser.EqualsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hat}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterHat(@NotNull CC5Parser.HatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hat}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitHat(@NotNull CC5Parser.HatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plus}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterPlus(@NotNull CC5Parser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitPlus(@NotNull CC5Parser.PlusContext ctx);
}