package ru.ctddev.verifier.conversion

import ru.ctddev.verifier.buchi.PropositionSet
import ru.ctddev.verifier.ltl.*

/**
 * Closure of sub-formulas of `this` under negation.
 */
fun Ltl.closure(): Set<Ltl> {
  val cl = mutableSetOf<Ltl>(True, False)

  fun add(ltl: Ltl) {
    val nnf = ltl.toNegatedNormalForm()

    //f in closure
    cl += nnf

    //f1 in closure => neg(f1) in closure
    cl += nnf.neg().toNegatedNormalForm()
  }

  fun traverse(ltl: Ltl) {
    add(ltl)
    return with(ltl) {
      when (this) {
        //X f1 in closure => f1 in closure
        is X -> traverse(formula)

        //a & b in closure => a, b in closure
        is And -> {
          traverse(left)
          traverse(right)
        }

        //a | b in closure => a, b in closure
        is Or -> {
          traverse(left)
          traverse(right)
        }

        //a U b in closure => a, b in closure
        is U -> {
          traverse(left)
          traverse(right)
        }

        //a R b in closure => a, b in closure
        is R -> {
          traverse(left)
          traverse(right)
        }

        is Implies -> {
          traverse(left)
          traverse(right)
        }

        is Proposition -> Unit
        is Not -> traverse(formula)
        is F -> traverse(formula)
        is G -> traverse(formula)
      }
    }
  }

  traverse(this)
  return cl
}

private class LtlToGlba(private val ltl: Ltl) {

  private val ltlNodeToState = mutableMapOf<LtlNode, GlbaState>()

  private fun LtlNode.toState() =
    ltlNodeToState.getOrPut(this) { GlbaState(id) }

  fun convert(): GLBA {
    val propositions = ltl.allPropositions()

    val nodes = ltl.toNegatedNormalForm().toLtlNodes()

    val states = nodes.map { it.toState() }
    val labels = mutableMapOf<GlbaState, PropositionSet>()
    val transitions = mutableMapOf<GlbaState, MutableSet<GlbaState>>()
    val finishSets = mutableListOf<Set<GlbaState>>()

    for (node in nodes) {
      val minBound = propositions intersect node.old.filterIsInstance<Proposition>()
      val maxBound = propositions.filterTo(mutableSetOf()) { it.neg() !in node.old }
      labels[node.toState()] = PropositionSet(minBound, maxBound)
    }

    for (node in nodes) {
      for (from in node.incoming) {
        if (from.id != 0) {
          transitions.getOrPut(from.toState()) { mutableSetOf() }.add(node.toState())
        }
      }
    }

    for (g in ltl.closure()) {
      if (g is U) {
        val finishSet = nodes
          .filter { g.right in it.old || g !in it.old }
          .mapTo(mutableSetOf()) { it.toState() }
        finishSets += finishSet
      }
    }

    val start = nodes.filter { it.incoming.any { it.id == 0 } }.map { it.toState() }
    return GLBA(states, start, labels, transitions, finishSets)
  }
}

fun Ltl.toGlba(): GLBA = LtlToGlba(this).convert()