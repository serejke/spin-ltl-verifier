package ru.ctddev.verifier.conversion

import ru.ctddev.verifier.buchi.Buchi
import ru.ctddev.verifier.buchi.BuchiState
import ru.ctddev.verifier.buchi.BuchiTransition

/**
 * Converts generalized labeled buchi automaton
 * to ordinary buchi automaton, which has only one
 * set of accepting states.
 */
class GlbaToBuchi(private val glba: GLBA) {

  private val states = mutableSetOf<BuchiState>()

  private val transitions = mutableMapOf<BuchiState, MutableList<BuchiTransition>>()

  fun convert(): Buchi {
    val startStates = glba.start.map { BuchiState.ByGlba(it, 0) }

    for (state in startStates) {
      if (state !in states) {
        traverse(state)
      }
    }

    val finish = if (glba.finishSets.isEmpty()) {
      /**
       * If the set of finish sets is empty in generalized Buchi automaton,
       * it means that any infinite path in the corresponding Buchi automaton
       * is accepting. Thus, mark all states as accepting.
       */
      states
    } else {
      glba.finishSets[0].mapTo(mutableSetOf()) { BuchiState.ByGlba(it, 0) }
    }

    return Buchi(states, startStates, finish, transitions)
  }

  private fun traverse(current: BuchiState.ByGlba) {
    states += current
    val n = glba.finishSets.size

    val (q, index) = current
    for (qTo in glba.transitions[q].orEmpty()) {

      val indexTo = if (index < n && q in glba.finishSets[index]) {
        (index + 1) % n
      } else {
        index
      }

      val toState = BuchiState.ByGlba(qTo, indexTo)

      val propositionSet = glba.labels[q]!!
      val transition = BuchiTransition.ByGlba(toState, propositionSet)
      transitions.getOrPut(current) { mutableListOf() }.add(transition)

      if (toState !in states) {
        traverse(toState)
      }
    }
  }


}

fun GLBA.toBuchi() = GlbaToBuchi(this).convert()