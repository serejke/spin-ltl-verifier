package ru.ctddev.verifier.ltl

import org.antlr.v4.runtime.tree.TerminalNode
import ru.ctddev.verifier.expr.*
import ru.ifmo.ctddev.verifier.LtlBaseVisitor
import ru.ifmo.ctddev.verifier.LtlParser

class BuildExprVisitor : LtlBaseVisitor<Expr>() {
  override fun visitCondImpl(ctx: LtlParser.CondImplContext): Expr =
    visit(ctx.left) implication visit(ctx.right)

  override fun visitCondParen(ctx: LtlParser.CondParenContext): Expr =
    visit(ctx.body)

  override fun visitCondAnd(ctx: LtlParser.CondAndContext): Expr =
    visit(ctx.left) and visit(ctx.right)

  override fun visitCondOr(ctx: LtlParser.CondOrContext): Expr =
    visit(ctx.left) or visit(ctx.right)

  override fun visitCondNot(ctx: LtlParser.CondNotContext): Expr =
    not(visit(ctx.body))

  override fun visitCondExpr(ctx: LtlParser.CondExprContext): Expr =
    visitExpr(ctx.expr())

  override fun visitExpr(ctx: LtlParser.ExprContext): Expr {
    val left = visit(ctx.left)
    val rightCtx = ctx.right
    if (rightCtx != null) {
      val right = visit(rightCtx)
      return when (ctx.cmpSign.type) {
        LtlParser.EQUAL -> left.eq(right)
        LtlParser.NOT_EQUAL -> left.notEq(right)
        LtlParser.LT -> left.lt(right)
        LtlParser.LE -> left.le(right)
        LtlParser.GT -> left.gt(right)
        LtlParser.GE -> left.ge(right)
        else -> throw IllegalStateException()
      }
    }
    return left
  }

  override fun visitSimpleExpr(ctx: LtlParser.SimpleExprContext): Expr {
    var expr = visit(ctx.term(0))
    for (i in IntProgression.fromClosedRange(1, ctx.childCount - 1, 2)) {
      val sign = (ctx.getChild(i) as TerminalNode).symbol
      val subTerm = ctx.getChild(i + 1)
      val subExpr = visit(subTerm)
      expr = when (sign.type) {
        LtlParser.PLUS -> expr.plus(subExpr)
        LtlParser.MINUS -> expr.minus(subExpr)
        else -> throw IllegalStateException()
      }
    }
    return expr
  }

  override fun visitSignedTerm(ctx: LtlParser.SignedTermContext): Expr {
    var expr = visit(ctx.signedFactor(0))
    for (i in IntProgression.fromClosedRange(1, ctx.childCount - 1, 2)) {
      val sign = (ctx.getChild(i) as TerminalNode).symbol
      val subTerm = ctx.getChild(i + 1)
      val subExpr = visit(subTerm)
      expr = when (sign.type) {
        LtlParser.STAR -> expr.multiply(subExpr)
        LtlParser.SLASH -> expr.divide(subExpr)
        else -> throw IllegalStateException()
      }
    }
    return expr
  }

  override fun visitParenTerm(ctx: LtlParser.ParenTermContext): Expr =
    visit(ctx.simpleExpr())

  override fun visitSignedFactor(ctx: LtlParser.SignedFactorContext): Expr {
    val expr = visit(ctx.factor())
    if (ctx.MINUS() != null) {
      return negative(expr)
    }
    return expr
  }

  override fun visitFactTrueOrFalse(ctx: LtlParser.FactTrueOrFalseContext) =
    visitTrueOrFalse(ctx.trueOrFalse())

  override fun visitTrueOrFalse(ctx: LtlParser.TrueOrFalseContext): Expr {
    val isTrue = ctx.TRUE() != null
    return if (isTrue) TrueExpr else FalseExpr
  }

  override fun visitFactNumber(ctx: LtlParser.FactNumberContext) =
    ValueExpr(IntValue(ctx.NUM_INT().text.toInt()))

  override fun visitVar(ctx: LtlParser.VarContext) =
    VarExpr(ctx.IDENT().text)
}