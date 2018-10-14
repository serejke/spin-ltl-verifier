// Generated from ru/ifmo/ctddev/verifier/Ltl.g4 by ANTLR 4.7.1
package ru.ifmo.ctddev.verifier;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LtlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LtlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LtlParser#ltl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtl(LtlParser.LtlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltlAnd}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtlAnd(LtlParser.LtlAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltlImpl}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtlImpl(LtlParser.LtlImplContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltlParen}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtlParen(LtlParser.LtlParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltlUntil}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtlUntil(LtlParser.LtlUntilContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltlFuture}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtlFuture(LtlParser.LtlFutureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltlRelease}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtlRelease(LtlParser.LtlReleaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltlGlobally}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtlGlobally(LtlParser.LtlGloballyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltlNeg}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtlNeg(LtlParser.LtlNegContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltlNext}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtlNext(LtlParser.LtlNextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltlExpr}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtlExpr(LtlParser.LtlExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltlOr}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtlOr(LtlParser.LtlOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condImpl}
	 * labeled alternative in {@link LtlParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondImpl(LtlParser.CondImplContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condParen}
	 * labeled alternative in {@link LtlParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondParen(LtlParser.CondParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condExpr}
	 * labeled alternative in {@link LtlParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondExpr(LtlParser.CondExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condAnd}
	 * labeled alternative in {@link LtlParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondAnd(LtlParser.CondAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condOr}
	 * labeled alternative in {@link LtlParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondOr(LtlParser.CondOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condNot}
	 * labeled alternative in {@link LtlParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondNot(LtlParser.CondNotContext ctx);
	/**
	 * Visit a parse tree produced by {@link LtlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(LtlParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LtlParser#simpleExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpr(LtlParser.SimpleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code signedTerm}
	 * labeled alternative in {@link LtlParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedTerm(LtlParser.SignedTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenTerm}
	 * labeled alternative in {@link LtlParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenTerm(LtlParser.ParenTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link LtlParser#signedFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedFactor(LtlParser.SignedFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factNumber}
	 * labeled alternative in {@link LtlParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactNumber(LtlParser.FactNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factTrueOrFalse}
	 * labeled alternative in {@link LtlParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactTrueOrFalse(LtlParser.FactTrueOrFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factVar}
	 * labeled alternative in {@link LtlParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactVar(LtlParser.FactVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link LtlParser#trueOrFalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueOrFalse(LtlParser.TrueOrFalseContext ctx);
	/**
	 * Visit a parse tree produced by {@link LtlParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(LtlParser.VarContext ctx);
}