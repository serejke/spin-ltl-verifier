package ru.ctddev.verifier.expr

data class UnaryOperation(val sign: String, val evaluate: (Value) -> Value) {
  fun presentable(expr: Expr) = when (expr) {
    is BinaryExpr -> "$sign$expr"
    else -> "$sign($expr)"
  }
}

data class BinaryOperation(val sign: String, val evaluate: (Value, Value) -> Value) {
  fun presentable(left: Expr, right: Expr) = "$left $sign $right"
}

private fun buildComparisonOperation(sign: String, compare: (Int, Int) -> Boolean) =
  BinaryOperation(sign) { left, right ->
    check(left is IntValue && right is IntValue) { "Type must be integer for both operands, but was ${left.type} and ${right.type}" }
    val computed = compare(left.value, right.value)
    if (computed) TrueValue else FalseValue
  }

private fun buildBooleanOperation(sign: String, compute: (Boolean, Boolean) -> Boolean) =
  BinaryOperation(sign) { left, right ->
    check(left is BoolValue && right is BoolValue) { "This operation ('$sign') can only applied to boolean types" }
    if (compute(left.value, right.value)) TrueValue else FalseValue
  }

private fun buildNumericOperation(sign: String, compute: (Int, Int) -> Int) =
  BinaryOperation(sign) { left, right ->
    check(left is IntValue && right is IntValue) { "This operation ('$sign') can only applied to integer types" }
    IntValue(compute(left.value, right.value))
  }

val negateOp = UnaryOperation("-") { IntValue((it as IntValue).value.unaryMinus()) }
val notOp = UnaryOperation("!") { if ((it as BoolValue).value) FalseValue else TrueValue }

val plusOp = buildNumericOperation("+") { a, b -> a + b }
val minusOp = buildNumericOperation("-") { a, b -> a - b }
val multiplyOp = buildNumericOperation("*") { a, b -> a * b }
val divideOp = buildNumericOperation("/") { a, b -> a / b }

val eqOp = buildComparisonOperation("=") { a, b -> a == b }
val notEqOp = buildComparisonOperation("!=") { a, b -> a != b }

val gtOp = buildComparisonOperation(">") { a, b -> a > b }
val geOp = buildComparisonOperation(">=") { a, b -> a >= b }
val ltOp = buildComparisonOperation("<") { a, b -> a < b }
val leOp = buildComparisonOperation("<=") { a, b -> a <= b }

val andOp = buildBooleanOperation("&") { a, b -> a && b }
val orOp = buildBooleanOperation("|") { a, b -> a || b }
val implOp = buildBooleanOperation("->") { a, b -> !a || b }