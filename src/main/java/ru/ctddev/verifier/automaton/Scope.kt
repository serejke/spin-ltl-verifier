package ru.ctddev.verifier.automaton

import ru.ctddev.verifier.expr.Value

typealias VarName = String

/**
 * Scope of execution, consisting of variables and their values.
 */
data class Scope(private val values: Map<VarName, Value>) {
  /**
   * Returns value of [variable] in this scope,
   * or `null` if the variable is not defined.
   */
  fun getVarValue(varName: VarName): Value? = values[varName]

  /**
   * Creates a new scope with values of variables
   * updated according to [vars] list.
   */
  fun updateVarValues(vars: List<Pair<VarName, Value>>): Scope =
    copy(values = values + vars)

  override fun toString() =
    values.entries.joinToString(prefix = "{", postfix = "}") { (varName, value) -> "$varName = $value" }

}