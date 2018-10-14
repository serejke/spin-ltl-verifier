package ru.ctddev.verifier.parsing

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import ru.ctddev.verifier.expr.Expr
import ru.ctddev.verifier.ltl.BuildExprVisitor
import ru.ctddev.verifier.ltl.BuildLtlVisitor
import ru.ctddev.verifier.ltl.Ltl
import ru.ifmo.ctddev.verifier.LtlLexer
import ru.ifmo.ctddev.verifier.LtlParser

fun parseLtl(ltlStr: String): Ltl {
  val ltlParser = initLtlParser(ltlStr)
  val ltl = ltlParser.ltl()
  return BuildLtlVisitor().visit(ltl)
}

fun parseExpr(exprStr: String): Expr {
  val ltlParser = initLtlParser(exprStr)
  val expr = ltlParser.expr()
  return BuildExprVisitor().visit(expr)
}

fun parseCondition(condStr: String): Expr {
  val ltlParser = initLtlParser(condStr)
  val condition = ltlParser.condition()
  return BuildExprVisitor().visit(condition)
}

private fun initLtlParser(str: String): LtlParser {
  val inputStream = CharStreams.fromString(str)
  val ltlLexer = LtlLexer(inputStream)
  val tokenStream = CommonTokenStream(ltlLexer)
  return LtlParser(tokenStream)
}