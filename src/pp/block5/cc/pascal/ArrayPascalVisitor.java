// Generated from /home/antoine/ownCloud/documents/[werk]/P-project/CF50/vb/src/pp/block5/cc/pascal/ArrayPascal.g4 by ANTLR 4.5
package pp.block5.cc.pascal;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ArrayPascalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ArrayPascalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code idTarget}
	 * labeled alternative in {@link ArrayPascalParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdTarget(@NotNull ArrayPascalParser.IdTargetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayTarget}
	 * labeled alternative in {@link ArrayPascalParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTarget(@NotNull ArrayPascalParser.ArrayTargetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexExpr(@NotNull ArrayPascalParser.IndexExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(@NotNull ArrayPascalParser.ParExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(@NotNull ArrayPascalParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueExpr(@NotNull ArrayPascalParser.TrueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpr(@NotNull ArrayPascalParser.CompExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prfExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrfExpr(@NotNull ArrayPascalParser.PrfExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseExpr(@NotNull ArrayPascalParser.FalseExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(@NotNull ArrayPascalParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumExpr(@NotNull ArrayPascalParser.NumExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExpr(@NotNull ArrayPascalParser.PlusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link ArrayPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(@NotNull ArrayPascalParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link ArrayPascalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(@NotNull ArrayPascalParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link ArrayPascalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(@NotNull ArrayPascalParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link ArrayPascalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(@NotNull ArrayPascalParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArrayPascalParser#bound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBound(@NotNull ArrayPascalParser.BoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArrayPascalParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull ArrayPascalParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArrayPascalParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(@NotNull ArrayPascalParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDecl}
	 * labeled alternative in {@link ArrayPascalParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(@NotNull ArrayPascalParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArrayPascalParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(@NotNull ArrayPascalParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArrayPascalParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull ArrayPascalParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assStat}
	 * labeled alternative in {@link ArrayPascalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssStat(@NotNull ArrayPascalParser.AssStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link ArrayPascalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(@NotNull ArrayPascalParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link ArrayPascalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(@NotNull ArrayPascalParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link ArrayPascalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStat(@NotNull ArrayPascalParser.BlockStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inStat}
	 * labeled alternative in {@link ArrayPascalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInStat(@NotNull ArrayPascalParser.InStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code outStat}
	 * labeled alternative in {@link ArrayPascalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutStat(@NotNull ArrayPascalParser.OutStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArrayPascalParser#prfOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrfOp(@NotNull ArrayPascalParser.PrfOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArrayPascalParser#multOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultOp(@NotNull ArrayPascalParser.MultOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArrayPascalParser#plusOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusOp(@NotNull ArrayPascalParser.PlusOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArrayPascalParser#boolOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOp(@NotNull ArrayPascalParser.BoolOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArrayPascalParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(@NotNull ArrayPascalParser.CompOpContext ctx);
}