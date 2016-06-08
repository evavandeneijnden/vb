// Generated from C:/Users/Eva/Documents/vb/block 4/src/cc/antlr/CC5\CC5.g4 by ANTLR 4.5.1
package cc.antlr.CC5;
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
	void enterStr(CC5Parser.StrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code str}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitStr(CC5Parser.StrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(CC5Parser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(CC5Parser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterBool(CC5Parser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitBool(CC5Parser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code num}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterNum(CC5Parser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code num}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitNum(CC5Parser.NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equals}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterEquals(CC5Parser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equals}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitEquals(CC5Parser.EqualsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hat}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterHat(CC5Parser.HatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hat}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitHat(CC5Parser.HatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plus}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterPlus(CC5Parser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link CC5Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitPlus(CC5Parser.PlusContext ctx);
}