// Generated from C:/Users/Eva/Documents/vb/block 3/src/pp/block3/cc/antlr/CC5\CC5Attr.g4 by ANTLR 4.5.1
package pp.block3.cc.antlr.CC5;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link CC5AttrVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class CC5AttrBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements CC5AttrVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitTerm(CC5AttrParser.TermContext ctx) { return visitChildren(ctx); }
}