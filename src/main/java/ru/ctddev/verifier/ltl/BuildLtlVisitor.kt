package ru.ctddev.verifier.ltl

import ru.ifmo.ctddev.verifier.LtlBaseVisitor
import ru.ifmo.ctddev.verifier.LtlParser

class BuildLtlVisitor : LtlBaseVisitor<Ltl>() {
  override fun visitLtl(ctx: LtlParser.LtlContext): Ltl =
    visit(ctx.formula())

  override fun visitLtlAnd(ctx: LtlParser.LtlAndContext) =
    visit(ctx.left) and visit(ctx.right)

  override fun visitLtlImpl(ctx: LtlParser.LtlImplContext) =
    visit(ctx.left) implies visit(ctx.right)

  override fun visitLtlUntil(ctx: LtlParser.LtlUntilContext) =
    visit(ctx.left) U visit(ctx.right)

  override fun visitLtlRelease(ctx: LtlParser.LtlReleaseContext) =
    visit(ctx.left) R visit(ctx.right)

  override fun visitLtlNeg(ctx: LtlParser.LtlNegContext) =
    not(visit(ctx.formula()))

  override fun visitLtlFuture(ctx: LtlParser.LtlFutureContext) =
    F(visit(ctx.body))

  override fun visitLtlNext(ctx: LtlParser.LtlNextContext) =
    X(visit(ctx.body))

  override fun visitLtlGlobally(ctx: LtlParser.LtlGloballyContext) =
    G(visit(ctx.body))

  override fun visitLtlExpr(ctx: LtlParser.LtlExprContext) = visitExpr(ctx.expr())

  override fun visitLtlOr(ctx: LtlParser.LtlOrContext) = visit(ctx.left) or visit(ctx.right)

  override fun visitLtlParen(ctx: LtlParser.LtlParenContext): Ltl = visit(ctx.body)

  override fun visitExpr(ctx: LtlParser.ExprContext): Ltl {
    val expr = BuildExprVisitor().visit(ctx)
    return Proposition(expr)
  }
}