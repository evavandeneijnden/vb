// Generated from C:/Users/Eva/Documents/vb/block 3/src/pp/block3/cc/tabular\Tex.g4 by ANTLR 4.5.1
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TexParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TexVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TexParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(TexParser.TableContext ctx);
	/**
	 * Visit a parse tree produced by {@link TexParser#beginTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginTable(TexParser.BeginTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link TexParser#row}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow(TexParser.RowContext ctx);
	/**
	 * Visit a parse tree produced by {@link TexParser#endTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndTable(TexParser.EndTableContext ctx);
}