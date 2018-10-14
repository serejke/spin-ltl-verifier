package ru.ctddev.verifier.ltl

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.ctddev.verifier.parsing.parseLtl

class LtlParserTest {
  @Test
  fun `parsing test`() {
    assertParse("x", "x")
    assertParse("F x", "F x")
    assertParse("F x", "F (x)")
    assertParse("F (F x)", "F (F x)")
    assertParse("false R x = 0", "false R x = 0")
  }

  private fun assertParse(expectedToString: String, ltlStr: String) {
    assertEquals(expectedToString, parseLtl(ltlStr).toString())
  }
}