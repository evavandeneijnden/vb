// Generated from /home/antoine/ownCloud/documents/[werk]/P-project/CF50/vb/src/pp/s1378791/q1_5/TypeUse.g4 by ANTLR 4.5
package pp.homework.q1_5;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TypeUseParser}.
 */
public interface TypeUseListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TypeUseParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull TypeUseParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeUseParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull TypeUseParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeUseParser#series}.
	 * @param ctx the parse tree
	 */
	void enterSeries(@NotNull TypeUseParser.SeriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeUseParser#series}.
	 * @param ctx the parse tree
	 */
	void exitSeries(@NotNull TypeUseParser.SeriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnit(@NotNull TypeUseParser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnit(@NotNull TypeUseParser.UnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeUseParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(@NotNull TypeUseParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeUseParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(@NotNull TypeUseParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeUseParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(@NotNull TypeUseParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeUseParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(@NotNull TypeUseParser.AssignContext ctx);
}