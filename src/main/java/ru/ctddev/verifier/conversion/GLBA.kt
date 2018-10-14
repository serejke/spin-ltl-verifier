package ru.ctddev.verifier.conversion

import ru.ctddev.verifier.buchi.PropositionSet

typealias GlbaStateId = Int

data class GlbaState(val stateId: GlbaStateId) {
  override fun toString() = stateId.toString()
}

/**
 * Generalized labeled buchi automaton.
 */
class GLBA(
  val states: List<GlbaState>,
  val start: List<GlbaState>,
  val labels: Map<GlbaState, PropositionSet>,
  val transitions: Map<GlbaState, Set<GlbaState>>,
  val finishSets: List<Set<GlbaState>>
) {
  override fun toString() =
    buildString {
      appendln("States: " + states.joinToString())
      appendln("Start: " + start.joinToString())
      appendln("Labels: ")
      for ((state, propositionSet) in labels) {
        appendln("\t$state: $propositionSet")
      }
      appendln("Transitions: ")
      for ((from, tos) in transitions) {
        appendln("\t$from -> ")
        for (to in tos) {
          appendln("\t\t$to")
        }
      }
      appendln("Finish sets: ")
      for ((index, finishSet) in finishSets.withIndex()) {
        appendln("\t#$index: " + finishSet.joinToString())
      }
    }
}