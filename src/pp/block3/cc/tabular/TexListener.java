// Generated from /home/antoine/ownCloud/documents/[werk]/P-project/CF50/vb/src/pp/block3/cc/tabular/Tex.g4 by ANTLR 4.5
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TexParser}.
 */
public interface TexListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TexParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(@NotNull TexParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TexParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(@NotNull TexParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link TexParser#beginTable}.
	 * @param ctx the parse tree
	 */
	void enterBeginTable(@NotNull TexParser.BeginTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TexParser#beginTable}.
	 * @param ctx the parse tree
	 */
	void exitBeginTable(@NotNull TexParser.BeginTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link TexParser#row}.
	 * @param ctx the parse tree
	 */
	void enterRow(@NotNull TexParser.RowContext ctx);
	/**
	 * Exit a parse tree produced by {@link TexParser#row}.
	 * @param ctx the parse tree
	 */
	void exitRow(@NotNull TexParser.RowContext ctx);
	/**
	 * Enter a parse tree produced by {@link TexParser#endTable}.
	 * @param ctx the parse tree
	 */
	void enterEndTable(@NotNull TexParser.EndTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TexParser#endTable}.
	 * @param ctx the parse tree
	 */
	void exitEndTable(@NotNull TexParser.EndTableContext ctx);
}