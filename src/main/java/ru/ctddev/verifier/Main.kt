package ru.ctddev.verifier

import ru.ctddev.verifier.automaton.parseAutomaton
import ru.ctddev.verifier.parsing.parseLtl
import java.io.File

private fun usage() {
  System.err.println("Usage: java -jar verifier.jar <automaton> <ltl formula>")
}

fun main(args: Array<String>) {
  if (args.size != 2) {
    usage()
    System.exit(1)
  }

  val automaton = parseAutomaton(File(args[0]))
  val ltl = parseLtl(args[1])

  val verifierResult = Verifier(ltl, automaton).verify()
  println(verifierResult)
}