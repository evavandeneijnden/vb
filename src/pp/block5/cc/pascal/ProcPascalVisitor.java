// Generated from /home/antoine/ownCloud/documents/[werk]/P-project/CF50/vb/src/pp/block5/cc/pascal/ProcPascal.g4 by ANTLR 4.5
package pp.block5.cc.pascal;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ProcPascalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ProcPascalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code funcDecl}
	 * labeled alternative in {@link ProcPascalParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDecl(@NotNull ProcPascalParser.FuncDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code procDecl}
	 * labeled alternative in {@link ProcPascalParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcDecl(@NotNull ProcPascalParser.ProcDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDecl}
	 * labeled alternative in {@link ProcPascalParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(@NotNull ProcPascalParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProcPascalParser#pars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPars(@NotNull ProcPascalParser.ParsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssStat(@NotNull ProcPascalParser.AssStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(@NotNull ProcPascalParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(@NotNull ProcPascalParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStat(@NotNull ProcPascalParser.BlockStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInStat(@NotNull ProcPascalParser.InStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code outStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutStat(@NotNull ProcPascalParser.OutStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallStat(@NotNull ProcPascalParser.CallStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exitStat}
	 * labeled alternative in {@link ProcPascalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExitStat(@NotNull ProcPascalParser.ExitStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProcPascalParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(@NotNull ProcPascalParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(@NotNull ProcPascalParser.ParExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueExpr(@NotNull ProcPascalParser.TrueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpr(@NotNull ProcPascalParser.CompExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prfExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrfExpr(@NotNull ProcPascalParser.PrfExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpr(@NotNull ProcPascalParser.CallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseExpr(@NotNull ProcPascalParser.FalseExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(@NotNull ProcPascalParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumExpr(@NotNull ProcPascalParser.NumExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExpr(@NotNull ProcPascalParser.PlusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link ProcPascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(@NotNull ProcPascalParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProcPascalParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull ProcPascalParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProcPascalParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(@NotNull ProcPascalParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProcPascalParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(@NotNull ProcPascalParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProcPascalParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull ProcPascalParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idTarget}
	 * labeled alternative in {@link ProcPascalParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdTarget(@NotNull ProcPascalParser.IdTargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProcPascalParser#prfOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrfOp(@NotNull ProcPascalParser.PrfOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProcPascalParser#multOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultOp(@NotNull ProcPascalParser.MultOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProcPascalParser#plusOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusOp(@NotNull ProcPascalParser.PlusOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProcPascalParser#boolOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOp(@NotNull ProcPascalParser.BoolOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProcPascalParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(@NotNull ProcPascalParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link ProcPascalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(@NotNull ProcPascalParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link ProcPascalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(@NotNull ProcPascalParser.BoolTypeContext ctx);
}