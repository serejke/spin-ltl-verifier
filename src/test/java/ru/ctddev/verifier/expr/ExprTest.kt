package ru.ctddev.verifier.expr

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.ctddev.verifier.automaton.Scope
import ru.ctddev.verifier.parsing.parseCondition

class ExprTest {
  @Test
  fun `parse and eval condition`() {
    val condition = parseCondition("a = 1 & a + b = 3 -> c = 4")
    val value = condition.evaluate(
      Scope(
        mapOf(
          "a" to 1,
          "b" to 2,
          "c" to 4
        ).mapValues { IntValue(it.value) }
      )
    ) as BoolValue
    assertEquals(TrueValue, value)
  }
}