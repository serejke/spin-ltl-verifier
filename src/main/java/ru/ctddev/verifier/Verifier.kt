package ru.ctddev.verifier

import ru.ctddev.verifier.automaton.Automaton
import ru.ctddev.verifier.automaton.toBuchi
import ru.ctddev.verifier.buchi.BuchiState
import ru.ctddev.verifier.buchi.PropositionSet
import ru.ctddev.verifier.buchi.emptyPropositionSet
import ru.ctddev.verifier.conversion.toBuchi
import ru.ctddev.verifier.intersection.IntersectionPathFinder
import ru.ctddev.verifier.intersection.UPath
import ru.ctddev.verifier.intersection.UState
import ru.ctddev.verifier.ltl.Ltl
import ru.ctddev.verifier.ltl.allPropositions
import ru.ctddev.verifier.ltl.neg
import ru.ctddev.verifier.ltl.toNegatedNormalForm

sealed class VerifierResult

data class CounterExample(
  val ltl: Ltl,
  val automaton: Automaton,
  val counterPath: UPath
) : VerifierResult() {

  private fun UState.asString(propositionSet: PropositionSet): String {
    val (stateId, scope) = first as BuchiState.ByAutomaton
    return "$stateId $scope" + if (propositionSet.isEmpty) "" else " where $propositionSet"
  }

  override fun toString() =
    buildString {
      appendln("Found counter-example for automaton '${automaton.name}' against LTL formula '$ltl':")
      var currentState = counterPath.startState
      for ((toState, propositionSet) in counterPath.transitions) {
        appendln(currentState.asString(propositionSet) + " -> ")
        currentState = toState
      }
      appendln("...")

      val acceptingState = counterPath.states().last()
      appendln("Found infinite cycle via state " + acceptingState.asString(emptyPropositionSet))
      appendln("that never satisfies formula '$ltl'")
    }
}

data class Valid(val ltl: Ltl, val automaton: Automaton) : VerifierResult() {
  override fun toString() = "Automaton '${automaton.name}' conforms to LTL formula '$ltl'"
}

class Verifier(
  val ltl: Ltl,
  val automaton: Automaton,
  val debugMode: Boolean = false
) {
  fun verify(): VerifierResult {
    val propositions = ltl.allPropositions()
    val buchiByAutomaton = automaton.toBuchi(propositions)

    val ltlNeg = ltl.neg()
    val buchiByLtlNeg = ltlNeg.toBuchi()

    if (debugMode) {
      println("Buchi for automaton '${automaton.name}':")
      println(buchiByAutomaton)

      println("Buchi for negation of LTL '$ltl' = '$ltlNeg' = '${ltlNeg.toNegatedNormalForm()}:")
      println(buchiByLtlNeg)
    }

    val counterPath = IntersectionPathFinder(buchiByAutomaton, buchiByLtlNeg).findIntersectionPath()
    return if (counterPath != null) {
      CounterExample(ltl, automaton, counterPath)
    } else {
      Valid(ltl, automaton)
    }
  }
}