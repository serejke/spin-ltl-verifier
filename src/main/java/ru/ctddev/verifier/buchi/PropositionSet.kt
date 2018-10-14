package ru.ctddev.verifier.buchi

import ru.ctddev.verifier.ltl.Proposition

/**
 * Represents all possible sets of propositions
 * on a transition in a buchi automaton.
 *
 * `∀ a: minBound ⊆ a ⊆ maxBound`
 * there is a transition by `a`
 * from state q1 to state q2.
 */
data class PropositionSet(val minBound: Set<Proposition>, val maxBound: Set<Proposition>) {

  init {
    check(minBound subsetOf maxBound)
  }

  val isEmpty: Boolean
    get() = maxBound.isEmpty()

  override fun toString() =
    when {
      isEmpty -> "∅"
      minBound == maxBound -> "{" + minBound.joinToString() + "}"
      else -> "({" + minBound.joinToString() + "}; {" + maxBound.joinToString() + "})"
    }
}

val emptyPropositionSet = PropositionSet(emptySet(), emptySet())

private infix fun <T> Set<T>.subsetOf(other: Set<T>): Boolean = other.containsAll(this)

private infix fun PropositionSet.subsetOf(other: PropositionSet): Boolean =
  other.minBound subsetOf minBound && maxBound subsetOf other.maxBound

/**
 * Intersects two proposition sets.
 *
 * If none of the sets is a subset of the other,
 * returns `null`, otherwise returns the smallest of two.
 */
infix fun PropositionSet.intersect(other: PropositionSet): PropositionSet? {
  if (this.subsetOf(other)) {
    return this
  }
  if (other subsetOf this) {
    return other
  }
  return null
}