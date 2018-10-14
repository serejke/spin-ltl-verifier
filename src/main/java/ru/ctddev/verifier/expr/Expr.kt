package ru.ctddev.verifier.expr

import ru.ctddev.verifier.automaton.Scope
import ru.ctddev.verifier.automaton.VarName

class UndefinedVariableException(message: String) : RuntimeException(message)

/**
 * Expr e := true | false | <num> | <var> | <arithmetic expr> | <boolean expr> | <comparison expr>
 */
sealed class Expr {
  @Throws(UndefinedVariableException::class)
  abstract fun evaluate(scope: Scope): Value
}

data class ValueExpr(val value: Value) : Expr() {
  override fun evaluate(scope: Scope) = value

  override fun toString() = value.toString()
}

val TrueExpr = ValueExpr(TrueValue)
val FalseExpr = ValueExpr(FalseValue)

data class VarExpr(val varName: VarName) : Expr() {

  override fun evaluate(scope: Scope): Value {
    return scope.getVarValue(varName)
      ?: throw UndefinedVariableException("Var $varName is not defined in scope $scope")
  }

  override fun toString() = varName
}

data class UnaryExpr(
  val body: Expr,
  val operation: UnaryOperation
) : Expr() {

  override fun evaluate(scope: Scope) =
    operation.evaluate(body.evaluate(scope))

  override fun toString() = operation.presentable(body)
}

data class BinaryExpr(
  val left: Expr,
  val right: Expr,
  val operation: BinaryOperation
) : Expr() {

  override fun evaluate(scope: Scope) = operation.evaluate(left.evaluate(scope), right.evaluate(scope))

  override fun toString() = operation.presentable(left, right)
}

fun negative(expr: Expr) = UnaryExpr(expr, negateOp)
fun not(expr: Expr) = UnaryExpr(expr, notOp)

infix fun Expr.plus(right: Expr) = BinaryExpr(this, right, plusOp)
infix fun Expr.minus(right: Expr) = BinaryExpr(this, right, minusOp)
infix fun Expr.divide(right: Expr) = BinaryExpr(this, right, divideOp)
infix fun Expr.multiply(right: Expr) = BinaryExpr(this, right, multiplyOp)

infix fun Expr.eq(right: Expr) = BinaryExpr(this, right, eqOp)
infix fun Expr.notEq(right: Expr) = BinaryExpr(this, right, notEqOp)

infix fun Expr.lt(right: Expr) = BinaryExpr(this, right, ltOp)
infix fun Expr.le(right: Expr) = BinaryExpr(this, right, leOp)
infix fun Expr.gt(right: Expr) = BinaryExpr(this, right, gtOp)
infix fun Expr.ge(right: Expr) = BinaryExpr(this, right, geOp)

infix fun Expr.and(right: Expr) = BinaryExpr(this, right, andOp)
infix fun Expr.or(right: Expr) = BinaryExpr(this, right, orOp)
infix fun Expr.implication(right: Expr) = BinaryExpr(this, right, implOp)

fun Expr.getAllVariables(): Set<VarName> =
  when (this) {
    is ValueExpr -> emptySet()
    is VarExpr -> setOf(varName)
    is UnaryExpr -> body.getAllVariables()
    is BinaryExpr -> left.getAllVariables() + right.getAllVariables()
  }