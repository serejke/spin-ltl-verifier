package ru.ctddev.verifier.automaton

import ru.ctddev.verifier.expr.Expr
import ru.ctddev.verifier.expr.Type
import ru.ctddev.verifier.expr.Value

typealias AStateId = Int

data class Automaton(
  val name: String,
  val start: AStateId,
  val initValues: Map<Variable, Value>,
  val states: List<AStateId>,
  val transitions: Map<AStateId, List<Transition>>
) {
  override fun toString() =
    buildString {
      appendln("Automaton: $name")
      appendln("Start: $start")
      appendln("States: " + states.joinToString())
      appendln("Initial values: ")
      for ((variable, value) in initValues) {
        appendln("\t$variable := $value")
      }
      appendln("Transitions: ")
      for ((from, transitions) in transitions) {
        appendln("\t$from -> ")
        for (transition in transitions) {
          transition.toString().lines().map { "\t\t$it" }.forEach {
            appendln(it)
          }
        }
      }
    }

}

data class Variable(
  val varName: VarName,
  val type: Type
) {
  override fun toString() = "$varName: $type"
}

data class Assignment(
  val variable: Variable,
  val newValue: Expr
) {
  override fun toString() = "$variable := $newValue"
}

data class Transition(
  val to: AStateId,
  val condition: Expr?,
  val assignments: List<Assignment>
) {
  override fun toString() =
    buildString {
      appendln("$to")
      if (condition != null) {
        appendln("if: $condition")
      }
      if (assignments.isNotEmpty()) {
        appendln("assignments: " + assignments.joinToString(separator = "; "))
      }
    }
}
