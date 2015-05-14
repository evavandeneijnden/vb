// Generated from C:/Users/Eva/Documents/vb/src/pp/block3/cc/antlr/CC5\CC5Attr.g4 by ANTLR 4.5
package pp.block3.cc.antlr.CC5;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CC5AttrParser}.
 */
public interface CC5AttrListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CC5AttrParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull CC5AttrParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link CC5AttrParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull CC5AttrParser.TermContext ctx);
}