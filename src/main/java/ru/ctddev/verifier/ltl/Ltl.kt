package ru.ctddev.verifier.ltl

import ru.ctddev.verifier.expr.Expr
import ru.ctddev.verifier.expr.FalseExpr
import ru.ctddev.verifier.expr.TrueExpr

//φ ::= p | !φ | φ & φ | φ '|' φ | (φ -> φ) | X φ | F φ | G φ | φ U φ | φ R φ
sealed class Ltl

data class Proposition(val proposition: Expr) : Ltl() {
  override fun toString() = proposition.toString()
}

data class Not(val formula: Ltl) : Ltl() {
  override fun toString() = "!" + formula.maybeWrap(this)
}

data class X(val formula: Ltl) : Ltl() {
  override fun toString() = "X " + formula.maybeWrap(this)
}

data class F(val formula: Ltl) : Ltl() {
  override fun toString() = "F " + formula.maybeWrap(this)
}

data class G(val formula: Ltl) : Ltl() {
  override fun toString() = "G " + formula.maybeWrap(this)
}

data class Or(val left: Ltl, val right: Ltl) : Ltl() {
  override fun toString() = left.maybeWrap(this) + " | " + right.maybeWrap(this)
}

data class And(val left: Ltl, val right: Ltl) : Ltl() {
  override fun toString() = left.maybeWrap(this) + " & " + right.maybeWrap(this)
}

data class Implies(val left: Ltl, val right: Ltl) : Ltl() {
  override fun toString() = left.maybeWrap(this) + " -> " + right.maybeWrap(this)
}

data class U(val left: Ltl, val right: Ltl) : Ltl() {
  override fun toString() = left.maybeWrap(this) + " U " + right.maybeWrap(this)
}

data class R(val left: Ltl, val right: Ltl) : Ltl() {
  override fun toString() = left.maybeWrap(this) + " R " + right.maybeWrap(this)
}

val True = Proposition(TrueExpr)
val False = Proposition(FalseExpr)

private fun Ltl.maybeWrap(parent: Ltl) =
  if (parent.priority >= priority) {
    "($this)"
  } else {
    "$this"
  }

private val Ltl.priority: Int
  get() = when (this) {
    is Implies -> 1
    is Or -> 2
    is And -> 3
    is U -> 4
    is R -> 4
    is X -> 5
    is F -> 5
    is G -> 5
    is Not -> 6
    is Proposition -> 7
  }

fun not(formula: Ltl) = Not(formula)

/**
 * Like [not] but also inverts negation.
 */
fun Ltl.neg() = when (this) {
  is Proposition -> negProposition()
  is Not -> formula
  else -> not(this)
}

private fun Proposition.negProposition(): Ltl = when (this) {
  True -> False
  False -> True
  else -> not(this)
}

infix fun Ltl.or(right: Ltl) = Or(this, right)

infix fun Ltl.and(right: Ltl): Ltl = And(this, right)

infix fun Ltl.implies(right: Ltl): Ltl = Implies(this, right)

infix fun Ltl.U(right: Ltl): Ltl = U(this, right)

//φ R ψ = !(!φ U !ψ)
infix fun Ltl.R(right: Ltl): Ltl = R(this, right)

/**
 * Replaces all sub-formulas "F φ" with "true U φ"
 */
private fun Ltl.eliminateF(): Ltl = when (this) {
  is F -> True U formula.eliminateF()
  is Proposition -> this

  is Not -> not(formula.eliminateF())
  is X -> X(formula.eliminateF())
  is G -> G(formula.eliminateF())
  is Or -> left.eliminateF() or right.eliminateF()
  is And -> left.eliminateF() and right.eliminateF()
  is Implies -> left.eliminateF() implies right.eliminateF()
  is U -> left.eliminateF() U right.eliminateF()
  is R -> left.eliminateF() R right.eliminateF()
}

/*
 * Replaces all sub-formulas "G φ" with "false R φ"
 */
private fun Ltl.eliminateG(): Ltl = when (this) {
  is G -> False R formula.eliminateG()

  is Proposition -> this

  is F -> F(formula.eliminateG())
  is Not -> not(formula.eliminateG())
  is X -> X(formula.eliminateG())
  is Or -> left.eliminateG() or right.eliminateG()
  is And -> left.eliminateG() and right.eliminateG()
  is Implies -> left.eliminateG() implies right.eliminateG()
  is U -> left.eliminateG() U right.eliminateG()
  is R -> left.eliminateG() R right.eliminateG()
}

/**
 * Replaces all boolean operations with combination of "!", "|" and "&".
 * In fact, it is only about replacing "a -> b" with "!a | b"
 */
private fun Ltl.eliminateImplies(): Ltl = when (this) {
  is Implies -> not(left.eliminateImplies()) or right.eliminateImplies()

  is Proposition -> this

  is Not -> not(formula.eliminateImplies())
  is X -> X(formula.eliminateImplies())
  is F -> F(formula.eliminateImplies())
  is G -> G(formula.eliminateImplies())
  is Or -> left.eliminateImplies() or right.eliminateImplies()
  is And -> left.eliminateImplies() and right.eliminateImplies()
  is U -> left.eliminateImplies() U right.eliminateImplies()
  is R -> left.eliminateImplies() R right.eliminateImplies()
}

/**
 * Applies the following equalities to
 * drown negations ("!") down to the propositions.
 *
 * !(φ U ψ) = !φ R !ψ
 * !(φ R ψ) = !φ U !ψ
 * !(X φ) = X !φ
 * !(φ | ψ) = !φ & !ψ
 * !(φ & ψ) = !φ | !ψ
 */
private fun Ltl.toNegatedForm(): Ltl = when (this) {
  is Not -> when (formula) {
    is U -> not(formula.left).toNegatedForm() R not(formula.right).toNegatedForm()
    is R -> not(formula.left).toNegatedForm() U not(formula.right).toNegatedForm()
    is X -> X(not(formula.formula).toNegatedForm())

    is Not -> formula.formula.toNegatedForm()
    is Or -> not(formula.left).toNegatedForm() and not(formula.right).toNegatedForm()
    is And -> not(formula.left).toNegatedForm() or not(formula.right).toNegatedForm()

    is Proposition -> formula.negProposition()

    is F, is G, is Implies -> throw AssertionError("Already replaced")
  }

  is Proposition -> this

  is X -> X(formula.toNegatedForm())
  is F -> F(formula.toNegatedForm())
  is G -> G(formula.toNegatedForm())

  is Or -> left.toNegatedForm() or right.toNegatedForm()
  is And -> left.toNegatedForm() and right.toNegatedForm()
  is Implies -> left.toNegatedForm() implies right.toNegatedForm()
  is U -> left.toNegatedForm() U right.toNegatedForm()
  is R -> left.toNegatedForm() R right.toNegatedForm()
}

fun Ltl.toNegatedNormalForm(): Ltl {
  //1) Replace all sub-formulas "F φ" on "true U φ"
  //2) Replace all sub-formulas "G φ" on "false R φ"
  //3) Leave only boolean operation "!", "|", "&".
  //4) Drown negations down to the propositions.
  return this
    .eliminateF()
    .eliminateG()
    .eliminateImplies()
    .toNegatedForm()
}

fun Ltl.isNegatedNormalForm(): Boolean =
  when (this) {
    is Proposition -> true
    is Not -> formula is Proposition

    is X -> formula.isNegatedNormalForm()
    is F -> formula.isNegatedNormalForm()
    is G -> formula.isNegatedNormalForm()

    is Or -> left.isNegatedNormalForm() && right.isNegatedNormalForm()
    is And -> left.isNegatedNormalForm() && right.isNegatedNormalForm()
    is Implies -> left.isNegatedNormalForm() && right.isNegatedNormalForm()
    is U -> left.isNegatedNormalForm() && right.isNegatedNormalForm()
    is R -> left.isNegatedNormalForm() && right.isNegatedNormalForm()
  }

/**
 * Returns all propositions encountered in `this` LTL formula.
 */
fun Ltl.allPropositions(): Set<Proposition> =
  when (this) {
    is Proposition -> setOf(this)

    is Not -> formula.allPropositions()
    is X -> formula.allPropositions()
    is F -> formula.allPropositions()
    is G -> formula.allPropositions()

    is Or -> left.allPropositions() + right.allPropositions()
    is And -> left.allPropositions() + right.allPropositions()
    is Implies -> left.allPropositions() + right.allPropositions()
    is U -> left.allPropositions() + right.allPropositions()
    is R -> left.allPropositions() + right.allPropositions()
  }
