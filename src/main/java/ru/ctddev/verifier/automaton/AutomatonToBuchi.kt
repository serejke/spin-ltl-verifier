package ru.ctddev.verifier.automaton

import ru.ctddev.verifier.buchi.Buchi
import ru.ctddev.verifier.buchi.BuchiState
import ru.ctddev.verifier.buchi.BuchiTransition
import ru.ctddev.verifier.buchi.PropositionSet
import ru.ctddev.verifier.expr.TrueValue
import ru.ctddev.verifier.ltl.Proposition

/**
 * Builds Buchi automaton for for ordinary [automaton]
 * by interpreting the program written on transitions,
 * which consists of [condition] [Transition.condition]
 * and [assignments] [Transition.assignments].
 *
 * [allPropositions] are propositions to record on transitions
 * of the resulting Buchi automaton.
 */
private class AutomatonToBuchi(
  private val automaton: Automaton,
  private val allPropositions: Set<Proposition>
) {

  private val transitions = mutableMapOf<BuchiState, MutableList<BuchiTransition>>()

  fun convert(): Buchi {
    val start = automaton.start
    val startScope = Scope(automaton.initValues.mapKeys { it.key.varName })
    val startBuchiState = BuchiState.ByAutomaton(start, startScope)

    interpret(start, startScope)

    val states = transitions.keys

    /**
     * In Buchi automaton built by ordinary automaton all states are accepting
     * because any path in it represents a valid program execution path.
     */
    @Suppress("UnnecessaryVariable")
    val finalStates = states

    /**
     * For terminating states, which have no further transitions,
     * add unconditional transitions to themselves,
     * and mark these transitions with met propositions.
     */
    for (state in states) {
      if (transitions[state]!!.isEmpty()) {
        val selfScope = (state as BuchiState.ByAutomaton).scope
        val selfPropositions = allPropositions.filterTo(mutableSetOf()) {
          it.proposition.evaluate(selfScope) == TrueValue
        }
        val selfPropositionSet = PropositionSet(selfPropositions, selfPropositions)
        transitions.getOrPut(state) { mutableListOf() }
          .add(BuchiTransition.ByAutomaton(state, selfPropositionSet, null, emptyList()))
      }
    }

    return Buchi(states, listOf(startBuchiState), finalStates, transitions)
  }

  private fun interpret(current: AStateId, scope: Scope): BuchiState.ByAutomaton {
    val currentState = BuchiState.ByAutomaton(current, scope)
    if (currentState in transitions) {
      return currentState
    }
    transitions[currentState] = mutableListOf()

    for ((to, condition, assignments) in automaton.transitions[current].orEmpty()) {
      if (condition == null || condition.evaluate(scope) == TrueValue) {
        val satisfiedPropositions =
          allPropositions.filterTo(mutableSetOf()) { it.proposition.evaluate(scope) == TrueValue }
        val propositionSet = PropositionSet(satisfiedPropositions, satisfiedPropositions)

        val newValues = assignments.map { (variable, assingmentExpr) ->
          variable.varName to assingmentExpr.evaluate(scope)
        }
        val newScope = scope.updateVarValues(newValues)

        val nextState = interpret(to, newScope)
        transitions[currentState]!! += BuchiTransition.ByAutomaton(nextState, propositionSet, condition, assignments)
      }
    }

    return currentState
  }
}

/**
 * Builds Buchi automaton for `this` ordinary automaton.
 * @param propositions propositions to test
 * on transitions of the Buchi automaton.
 */
fun Automaton.toBuchi(propositions: Set<Proposition>): Buchi = AutomatonToBuchi(this, propositions).convert()