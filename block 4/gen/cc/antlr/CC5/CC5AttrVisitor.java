// Generated from C:/Users/Eva/Documents/vb/block 4/src/cc/antlr/CC5\CC5Attr.g4 by ANTLR 4.5.1
package cc.antlr.CC5;
 import cc.antlr.Type;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CC5AttrParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CC5AttrVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CC5AttrParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(CC5AttrParser.TermContext ctx);
}