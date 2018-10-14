package ru.ctddev.verifier.ltl

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.ctddev.verifier.parsing.parseLtl

class LtlNnfTest {

  @Test
  fun toNegatedNormalForm() {
    assertEquals(
      "true U !flag",
      parseLtl("!G(flag)").toNegatedNormalForm().toString()
    )

    assertEquals(
      "true U (x = 0 & true U x > 0)",
      parseLtl("!G(x=0 -> !F(x > 0))").toNegatedNormalForm().toString()
    )

    assertEquals(
      "!a R !b | true U c",
      parseLtl("a U b -> F c").toNegatedNormalForm().toString()
    )
  }
}