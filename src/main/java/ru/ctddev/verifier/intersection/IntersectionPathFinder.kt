package ru.ctddev.verifier.intersection

import ru.ctddev.verifier.buchi.Buchi
import ru.ctddev.verifier.buchi.BuchiState
import ru.ctddev.verifier.buchi.PropositionSet
import ru.ctddev.verifier.buchi.intersect
import java.util.*

typealias UState = Pair<BuchiState, BuchiState>

data class UTransition(val toState: UState, val propositionSet: PropositionSet)

/**
 * Path in intersection Buchi automaton from [startState]
 * by [transitions].
 */
class UPath {

  lateinit var startState: UState

  val transitions: LinkedList<UTransition> = LinkedList()

  fun hasState(uState: UState): Boolean =
    uState == startState || transitions.any { it.toState == uState }

  fun addTransition(transition: UTransition) {
    transitions.addLast(transition)
  }

  fun removeLastTransition() {
    transitions.removeLast()
  }

  fun states(): List<UState> = listOf(startState) + transitions.map { it.toState }
}

infix operator fun UPath.plus(other: UPath): UPath {
  val uPath = UPath()
  uPath.startState = startState
  uPath.transitions += transitions
  uPath.transitions += other.transitions
  return uPath
}

class IntersectionPathFinder(private val b1: Buchi, private val b2: Buchi) {

  private val visited1 = mutableSetOf<UState>()

  private val visited2 = mutableSetOf<UState>()

  private val path1 = UPath()

  private val path2 = UPath()

  private val intersectionTransitions = mutableMapOf<UState, List<UTransition>>()

  private var foundPath: UPath? = null

  fun findIntersectionPath(): UPath? {
    for (start1 in b1.start) {
      for (start2 in b2.start) {
        val start = start1 to start2
        if (start !in visited1) {
          path1.startState = start
          check(path1.transitions.isEmpty())
          if (dfs1(start)) {
            return foundPath
          }
        }
      }
    }
    return null
  }

  private fun intersectedTransitions(uState: UState) =
    intersectionTransitions.getOrPut(uState) { evalTransitions(uState) }

  private fun evalTransitions(uState: UState): List<UTransition> {
    val (s1, s2) = uState
    val ts1 = b1.transitions[s1].orEmpty()
    val ts2 = b2.transitions[s2].orEmpty()
    val result = mutableListOf<UTransition>()
    for (t1 in ts1) {
      for (t2 in ts2) {
        val intersection = t1.propositionSet intersect t2.propositionSet
        if (intersection != null) {
          result += UTransition(t1.to to t2.to, intersection)
        }
      }
    }
    return result
  }

  /**
   * Builds path `<start> -> <accepting state> -> <cycle> -> <accepting state>`,
   * which is a proof of non-emptiness of the Buchi automatons intersection.
   */
  private fun buildPath() = path1 + path2

  private fun dfs2(uState: UState): Boolean {
    visited2 += uState

    val transitions = intersectedTransitions(uState)
    for (transition in transitions) {
      path2.addTransition(transition)

      val toState = transition.toState
      if (path1.hasState(toState)) {
        foundPath = buildPath()
        return true
      } else if (toState !in visited2) {
        if (dfs2(toState)) {
          return true
        }
      }

      path2.removeLastTransition()
    }
    return false
  }

  private fun dfs1(uState: UState): Boolean {
    visited1 += uState

    val transitions = intersectedTransitions(uState)
    for (transition in transitions) {
      path1.addTransition(transition)

      val toState = transition.toState
      if (toState !in visited1) {
        if (dfs1(toState)) {
          return true
        }
      }

      path1.removeLastTransition()
    }

    //Check if this state is accepting one
    if (uState.first in b1.finish && uState.second in b2.finish) {
      path2.startState = uState
      check(path2.transitions.isEmpty())
      if (dfs2(uState)) {
        return true
      }
    }

    return false
  }


}