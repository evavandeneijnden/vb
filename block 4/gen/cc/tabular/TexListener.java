// Generated from C:/Users/Eva/Documents/vb/block 4/src/cc/tabular\Tex.g4 by ANTLR 4.5.1
package cc.tabular;
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
	void enterTable(TexParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TexParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(TexParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link TexParser#beginTable}.
	 * @param ctx the parse tree
	 */
	void enterBeginTable(TexParser.BeginTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TexParser#beginTable}.
	 * @param ctx the parse tree
	 */
	void exitBeginTable(TexParser.BeginTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link TexParser#row}.
	 * @param ctx the parse tree
	 */
	void enterRow(TexParser.RowContext ctx);
	/**
	 * Exit a parse tree produced by {@link TexParser#row}.
	 * @param ctx the parse tree
	 */
	void exitRow(TexParser.RowContext ctx);
	/**
	 * Enter a parse tree produced by {@link TexParser#endTable}.
	 * @param ctx the parse tree
	 */
	void enterEndTable(TexParser.EndTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TexParser#endTable}.
	 * @param ctx the parse tree
	 */
	void exitEndTable(TexParser.EndTableContext ctx);
}