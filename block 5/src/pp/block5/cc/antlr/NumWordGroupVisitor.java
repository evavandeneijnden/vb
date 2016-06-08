// Generated from C:/Users/Eva/Documents/vb/src/pp/block5/cc/antlr\NumWordGroup.g4 by ANTLR 4.5
package pp.block5.cc.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NumWordGroupParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NumWordGroupVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NumWordGroupParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(@NotNull NumWordGroupParser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link NumWordGroupParser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(@NotNull NumWordGroupParser.GroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link NumWordGroupParser#penultimateGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPenultimateGroup(@NotNull NumWordGroupParser.PenultimateGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link NumWordGroupParser#lastGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastGroup(@NotNull NumWordGroupParser.LastGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link NumWordGroupParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(@NotNull NumWordGroupParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link NumWordGroupParser#word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWord(@NotNull NumWordGroupParser.WordContext ctx);
}