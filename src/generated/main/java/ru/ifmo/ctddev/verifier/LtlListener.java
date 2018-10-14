// Generated from ru/ifmo/ctddev/verifier/Ltl.g4 by ANTLR 4.7.1
package ru.ifmo.ctddev.verifier;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LtlParser}.
 */
public interface LtlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LtlParser#ltl}.
	 * @param ctx the parse tree
	 */
	void enterLtl(LtlParser.LtlContext ctx);
	/**
	 * Exit a parse tree produced by {@link LtlParser#ltl}.
	 * @param ctx the parse tree
	 */
	void exitLtl(LtlParser.LtlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltlAnd}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLtlAnd(LtlParser.LtlAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltlAnd}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLtlAnd(LtlParser.LtlAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltlImpl}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLtlImpl(LtlParser.LtlImplContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltlImpl}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLtlImpl(LtlParser.LtlImplContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltlParen}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLtlParen(LtlParser.LtlParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltlParen}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLtlParen(LtlParser.LtlParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltlUntil}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLtlUntil(LtlParser.LtlUntilContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltlUntil}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLtlUntil(LtlParser.LtlUntilContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltlFuture}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLtlFuture(LtlParser.LtlFutureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltlFuture}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLtlFuture(LtlParser.LtlFutureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltlRelease}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLtlRelease(LtlParser.LtlReleaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltlRelease}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLtlRelease(LtlParser.LtlReleaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltlGlobally}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLtlGlobally(LtlParser.LtlGloballyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltlGlobally}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLtlGlobally(LtlParser.LtlGloballyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltlNeg}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLtlNeg(LtlParser.LtlNegContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltlNeg}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLtlNeg(LtlParser.LtlNegContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltlNext}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLtlNext(LtlParser.LtlNextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltlNext}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLtlNext(LtlParser.LtlNextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltlExpr}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLtlExpr(LtlParser.LtlExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltlExpr}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLtlExpr(LtlParser.LtlExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltlOr}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLtlOr(LtlParser.LtlOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltlOr}
	 * labeled alternative in {@link LtlParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLtlOr(LtlParser.LtlOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condImpl}
	 * labeled alternative in {@link LtlParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondImpl(LtlParser.CondImplContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condImpl}
	 * labeled alternative in {@link LtlParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondImpl(LtlParser.CondImplContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condParen}
	 * labeled alternative in {@link LtlParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondParen(LtlParser.CondParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condParen}
	 * labeled alternative in {@link LtlParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondParen(LtlParser.CondParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condExpr}
	 * labeled alternative in {@link LtlParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondExpr(LtlParser.CondExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condExpr}
	 * labeled alternative in {@link LtlParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondExpr(LtlParser.CondExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condAnd}
	 * labeled alternative in {@link LtlParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondAnd(LtlParser.CondAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condAnd}
	 * labeled alternative in {@link LtlParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondAnd(LtlParser.CondAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condOr}
	 * labeled alternative in {@link LtlParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondOr(LtlParser.CondOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condOr}
	 * labeled alternative in {@link LtlParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondOr(LtlParser.CondOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condNot}
	 * labeled alternative in {@link LtlParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondNot(LtlParser.CondNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condNot}
	 * labeled alternative in {@link LtlParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondNot(LtlParser.CondNotContext ctx);
	/**
	 * Enter a parse tree produced by {@link LtlParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LtlParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LtlParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LtlParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LtlParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpr(LtlParser.SimpleExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LtlParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpr(LtlParser.SimpleExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code signedTerm}
	 * labeled alternative in {@link LtlParser#term}.
	 * @param ctx the parse tree
	 */
	void enterSignedTerm(LtlParser.SignedTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code signedTerm}
	 * labeled alternative in {@link LtlParser#term}.
	 * @param ctx the parse tree
	 */
	void exitSignedTerm(LtlParser.SignedTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenTerm}
	 * labeled alternative in {@link LtlParser#term}.
	 * @param ctx the parse tree
	 */
	void enterParenTerm(LtlParser.ParenTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenTerm}
	 * labeled alternative in {@link LtlParser#term}.
	 * @param ctx the parse tree
	 */
	void exitParenTerm(LtlParser.ParenTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link LtlParser#signedFactor}.
	 * @param ctx the parse tree
	 */
	void enterSignedFactor(LtlParser.SignedFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LtlParser#signedFactor}.
	 * @param ctx the parse tree
	 */
	void exitSignedFactor(LtlParser.SignedFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factNumber}
	 * labeled alternative in {@link LtlParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactNumber(LtlParser.FactNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factNumber}
	 * labeled alternative in {@link LtlParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactNumber(LtlParser.FactNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factTrueOrFalse}
	 * labeled alternative in {@link LtlParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactTrueOrFalse(LtlParser.FactTrueOrFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factTrueOrFalse}
	 * labeled alternative in {@link LtlParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactTrueOrFalse(LtlParser.FactTrueOrFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factVar}
	 * labeled alternative in {@link LtlParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactVar(LtlParser.FactVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factVar}
	 * labeled alternative in {@link LtlParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactVar(LtlParser.FactVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link LtlParser#trueOrFalse}.
	 * @param ctx the parse tree
	 */
	void enterTrueOrFalse(LtlParser.TrueOrFalseContext ctx);
	/**
	 * Exit a parse tree produced by {@link LtlParser#trueOrFalse}.
	 * @param ctx the parse tree
	 */
	void exitTrueOrFalse(LtlParser.TrueOrFalseContext ctx);
	/**
	 * Enter a parse tree produced by {@link LtlParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(LtlParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link LtlParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(LtlParser.VarContext ctx);
}