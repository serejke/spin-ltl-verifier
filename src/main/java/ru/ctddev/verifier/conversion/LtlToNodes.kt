package ru.ctddev.verifier.conversion

import ru.ctddev.verifier.ltl.*

typealias LtlNodeId = Int

data class LtlNode(
  val id: LtlNodeId,
  val incoming: MutableSet<LtlNode>,
  val old: MutableSet<Ltl>,
  val new: MutableSet<Ltl>,
  val next: MutableSet<Ltl>
) {
  override fun toString() = buildString {
    appendln("Node: $id")
    appendln("Incoming: " + incoming.joinToString { it.id.toString() })
    appendln("Old: " + old.joinToString())
    appendln("New: " + new.joinToString())
    appendln("Next: " + next.joinToString())
  }

  override fun equals(other: Any?) = other is LtlNode && id == other.id

  override fun hashCode() = id
}

/**
 * Converts [Ltl] formula to list of [LtlNode]s.
 * The LTL formula must be in negated normal form.
 */
private class LtlToNodes(private val ltlNnf: Ltl) {

  init {
    check(ltlNnf.isNegatedNormalForm()) { "$ltlNnf" }
  }

  private var nextId = 0

  private fun genNewId(): LtlNodeId = nextId++

  /**
   * Builds [LtlNode]s for [ltlNnf] in negated normal form.
   */
  fun createNodes(): List<LtlNode> {
    //Create start node with ID = 0.
    val startNode = createNode()

    val n = createNode(
      incoming = setOf(startNode),
      new = setOf(ltlNnf)
    )

    return expand(n, emptyList())
  }

  private fun createNode(
    incoming: Set<LtlNode> = emptySet(),
    old: Set<Ltl> = emptySet(),
    new: Set<Ltl> = emptySet(),
    next: Set<Ltl> = emptySet()
  ) = LtlNode(
    genNewId(),
    incoming.toMutableSet(),
    old.toMutableSet(),
    new.toMutableSet(),
    next.toMutableSet()
  )

  private fun expand(current: LtlNode, nodes: List<LtlNode>): List<LtlNode> =
    if (current.new.isEmpty()) {
      val r = nodes.find { it.old == current.old && it.next == current.next }
      if (r != null) {
        r.incoming += current.incoming
        nodes
      } else {
        val newNode = createNode(
          incoming = setOf(current),
          new = current.next
        )
        expand(newNode, nodes + listOf(current))
      }
    } else {
      val n = current.new.first()
      current.new.remove(n)
      when {
        n in current.old -> expand(current, nodes)
        n == False || n.neg() in current.old -> nodes
        n is Proposition || n is Not && n.formula is Proposition -> {
          val newNode = createNode(
            incoming = current.incoming,
            old = current.old + setOf(n),
            new = current.new,
            next = current.next
          )
          expand(newNode, nodes)
        }
        n is Or -> {
          val (f, g) = n

          val newNode1 = createNode(
            incoming = current.incoming,
            old = current.old + setOf(n),
            new = current.new + setOf(f),
            next = current.next
          )

          val newNode2 = createNode(
            incoming = current.incoming,
            old = current.old + setOf(n),
            new = current.new + setOf(g),
            next = current.next
          )

          expand(newNode2, expand(newNode1, nodes))
        }
        n is And -> {
          val (f, g) = n
          val newNode = createNode(
            incoming = current.incoming,
            old = current.old + setOf(n),
            new = current.new + setOf(f, g),
            next = current.next
          )
          expand(newNode, nodes)
        }
        n is X -> {
          val f = n.formula
          val newNode = createNode(
            incoming = current.incoming,
            old = current.old + setOf(n),
            new = current.new,
            next = current.next + setOf(f)
          )
          expand(newNode, nodes)
        }
        n is U -> {
          val (f, g) = n

          val newNode1 = createNode(
            incoming = current.incoming,
            old = current.old + setOf(n),
            new = current.new + setOf(f),
            next = current.next + setOf(n)
          )

          val newNode2 = createNode(
            incoming = current.incoming,
            old = current.old + setOf(n),
            new = current.new + setOf(g),
            next = current.next
          )

          expand(newNode2, expand(newNode1, nodes))
        }
        n is R -> {
          val (f, g) = n

          val newNode1 = createNode(
            incoming = current.incoming,
            old = current.old + setOf(n),
            new = current.new + setOf(f, g),
            next = current.next
          )

          val newNode2 = createNode(
            incoming = current.incoming,
            old = current.old + setOf(n),
            new = current.new + setOf(g),
            next = current.next + setOf(n)
          )

          expand(newNode2, expand(newNode1, nodes))
        }
        else -> throw AssertionError("$n")
      }
    }

}

fun Ltl.toLtlNodes(): List<LtlNode> = LtlToNodes(this).createNodes()