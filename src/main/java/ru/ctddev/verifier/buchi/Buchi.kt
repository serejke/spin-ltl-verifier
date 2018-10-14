package ru.ctddev.verifier.buchi

import ru.ctddev.verifier.automaton.AStateId
import ru.ctddev.verifier.automaton.Assignment
import ru.ctddev.verifier.automaton.Scope
import ru.ctddev.verifier.conversion.GlbaState
import ru.ctddev.verifier.expr.Expr

sealed class BuchiState {
  data class ByGlba(val glbaState: GlbaState, val index: Int) : BuchiState() {
    override fun toString() = "($glbaState, $index)"
  }

  data class ByAutomaton(val stateId: AStateId, val scope: Scope) : BuchiState() {
    override fun toString() = "$stateId $scope"
  }
}

sealed class BuchiTransition {

  abstract val to: BuchiState
  abstract val propositionSet: PropositionSet

  data class ByGlba(override val to: BuchiState.ByGlba, override val propositionSet: PropositionSet) :
    BuchiTransition() {
    override fun toString() = "$to via $propositionSet"
  }

  data class ByAutomaton(
    override val to: BuchiState.ByAutomaton,
    override val propositionSet: PropositionSet,
    val condition: Expr?,
    val assignments: List<Assignment>
  ) : BuchiTransition() {
    override fun toString() = buildString {
      append(to)
      if (condition != null) {
        append(" if ($condition)")
      }
      if (assignments.isNotEmpty()) {
        append(" with {" + assignments.joinToString { "${it.variable.varName} := ${it.newValue}" } + "}")
      }
      appendln(" via $propositionSet")
    }
  }
}

data class Buchi(
  val states: Set<BuchiState>,
  val start: List<BuchiState>,
  val finish: Set<BuchiState>,
  val transitions: Map<BuchiState, List<BuchiTransition>>
) {
  override fun toString() =
    buildString {
      appendln("States")
      for (state in states) {
        appendln("\t$state")
      }
      appendln("Start: ")
      for (state in start) {
        appendln("\t$state")
      }
      appendln("Finish")
      for (state in finish) {
        appendln("\t" + state)
      }
      appendln("Transitions")
      for ((from, transitions) in transitions) {
        append("\t$from -> ")
        if (transitions.isEmpty()) {
          appendln("∅")
        } else {
          appendln()
        }

        for (transition in transitions) {
          appendln("\t\t-> $transition")
        }
      }
    }
}