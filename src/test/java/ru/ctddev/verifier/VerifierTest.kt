package ru.ctddev.verifier

import org.junit.Assert.assertTrue
import org.junit.Test
import ru.ctddev.verifier.automaton.parseAutomaton
import ru.ctddev.verifier.parsing.parseLtl

/**
 * Verifier tests for conformity and non-conformity of automatons to LTL formulas.
 */
class VerifierTest : BaseTest() {

  /**
   * Runs verifier for automaton [automatonPath] against LTL formula [ltlStr].
   */
  private fun runVerifier(ltlStr: String, automatonPath: String): VerifierResult {
    val automatonFile = getTestDataFile(automatonPath)

    val automaton = parseAutomaton(automatonFile)
    val ltl = parseLtl(ltlStr)

    return Verifier(ltl, automaton, true).verify()
  }

  private fun assertValid(ltlStr: String, automatonPath: String) {
    val verifierResult = runVerifier(ltlStr, automatonPath)
    assertTrue(verifierResult.toString(), verifierResult is Valid)
  }

  private fun assertCounterExample(ltlStr: String, automatonPath: String) {
    val verifierResult = runVerifier(ltlStr, automatonPath)
    assertTrue(verifierResult.toString(), verifierResult is CounterExample)
  }

  /**
   * Tests automaton representing the following program:
   * ```
   * a = 0
   * if (a = 0) {
   *   a = 1
   * }
   * ```
   */
  @Test
  fun `next state`() {
    assertValid("X a = 1", "/testData/automatons/nextState.json")
    assertCounterExample("X a = 0", "/testData/automatons/nextState.json")

    assertCounterExample("G a = 1", "/testData/automatons/nextState.json")
  }

  /**
   * Tests automaton representing the following program:
   * ```
   * i = 0
   * while (i = 0) { }
   * ```
   */
  @Test
  fun `infinite loop`() {
    assertValid("G i = 0", "/testData/automatons/infiniteLoop.json")
    assertCounterExample("F i != 0", "/testData/automatons/infiniteLoop.json")
  }

  /**
   * Tests automaton representing the following program:
   * ```
   * i = 0, a = 1
   * while (i < 10) {
   *   atomic {
   *     i = i + 1
   *     a = a * 2
   *   }
   * }
   * ```
   *
   * where the outcome is (i = 10, a = 1024)
   */
  @Test
  fun `simple loop`() {
    assertValid("G (i <= 10)", "/testData/automatons/simpleLoop.json")
    assertValid("G (i = 2 -> a = 4)", "/testData/automatons/simpleLoop.json")
    assertValid("G (i = 10 -> a = 1024)", "/testData/automatons/simpleLoop.json")

    assertCounterExample("G (i = 2)", "/testData/automatons/simpleLoop.json")
  }

  /**
   * Tests automaton representing the following program:
   * ```
   * x = 1, y = 2
   * atomic {
   *   x := x + y
   *   y := y + x
   * }
   * ```
   *
   * The only possible outcome is (x = 3, y = 3)
   * because the operations are made atomically
   */
  @Test
  fun `atomic x y update`() {
    assertValid("x = 1 & y = 2 -> X (x = 3 & y = 3)", "/testData/automatons/atomicXYUpdate.json")
    assertCounterExample("G (x + y = 3)", "/testData/automatons/atomicXYUpdate.json")
  }

  /**
   * Tests automaton representing the following program:
   * ```
   * x = 1, y = 2
   * t1 = 0, t2 = 0
   *
   * a1: t1 := x         b1: t2 := y
   * a2: t1 := t1 + y    b2: t2 := t2 + x
   * a3: x := t1         b3: y := y2
   * ```
   *
   * where operations `a1, a2, a3, b1, b2, b3` may interleave.
   *
   * The program outcome depends on execution order:
   * ```
   * a1 a2 a3 b1 b2 b3 -> (x = 3, y = 5)
   * b1 b2 b3 a1 a2 a3 -> (x = 4, y = 3)
   * a1 b1 a2 b2 a3 b3 -> (x = 3, y = 3)
   * b1 a1 b2 a2 b3 a3 -> (x = 3, y = 3)
   * ```
   *
   * Note that outcomes (x = 3, y = 5) and (x = 4, y = 3)
   * would be impossible if `x` and `y` were updated atomically
   */
  @Test
  fun `non atomic x y update`() {
    assertCounterExample("x = 1 & y = 2 -> X (F (x = 3 & y = 3))", "/testData/automatons/nonAtomicXYUpdate.json")
    assertValid(
      "x = 1 & y = 2 -> X (F (x = 3 & y = 3 | x = 4 & y = 3 | x = 3 & y = 5))",
      "/testData/automatons/nonAtomicXYUpdate.json"
    )
  }
}