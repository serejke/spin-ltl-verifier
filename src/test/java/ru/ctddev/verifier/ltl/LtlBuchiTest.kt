package ru.ctddev.verifier.ltl

import org.junit.Assert.assertTrue
import org.junit.Test
import ru.ctddev.verifier.conversion.toBuchi
import ru.ctddev.verifier.parsing.parseLtl

class LtlBuchiTest {
  @Test
  fun `buchi for ltl with empty finish sets in GLBA`() {
    val ltl = parseLtl("X (a = 1)")
    val buchi = ltl.toBuchi()
    assertTrue(buchi.finish.isNotEmpty())
  }
}