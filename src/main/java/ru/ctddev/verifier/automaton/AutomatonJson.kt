package ru.ctddev.verifier.automaton

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import ru.ctddev.verifier.expr.*
import ru.ctddev.verifier.parsing.parseCondition
import java.io.File

private data class AutomatonJson(
  val name: String,
  val variables: List<VariableJson>,
  val start: Int,
  val states: List<Int>,
  val transitions: List<TransitionJson>
)

private data class VariableJson(
  val name: String,
  val type: String,
  val value: Any
)

private data class TransitionJson(
  val from: Int,
  val to: Int,
  val condition: String?,
  val assignments: List<String>?
)

private fun Any.parseInt() =
  when (this) {
    is Int -> this
    is String -> toIntOrNull()
    else -> null
  } ?: throw IllegalArgumentException("Cannot parse int from $this")

private fun Any.parseBool(): Boolean =
  when (this) {
    is Boolean -> this
    is String -> toBoolean()
    else -> throw IllegalArgumentException("Cannot parse boolean from $this")
  }

private fun parseValue(type: Type, any: Any): Value = when (type) {
  IntType -> IntValue(any.parseInt())
  BoolType -> if (any.parseBool()) TrueValue else FalseValue
}

private fun String.parseType(): Type = when (this) {
  "int" -> IntType
  "bool" -> BoolType
  else -> throw IllegalArgumentException("Unknown type")
}

private fun AutomatonJson.toAutomaton(): Automaton {
  val initValues = mutableMapOf<Variable, Value>()
  for (variable in variables) {
    val type = variable.type.parseType()
    val value = parseValue(type, variable.value)
    initValues[Variable(variable.name, type)] = value
  }

  val knownVariables = initValues.keys

  return Automaton(
    name,
    start,
    initValues,
    states,
    transitions
      .groupBy { it.from }
      .mapValues { it.value.map { json -> json.toTransition(knownVariables) } }
  )
}

private fun guardedParseExpr(exprStr: String, knownVariables: Set<Variable>): Expr {
  val expr = parseCondition(exprStr)
  val unknownVar = expr.getAllVariables().find { varName -> knownVariables.none { it.varName == varName } }
  require(unknownVar == null) { "Unknown variable $unknownVar in $expr" }
  return expr
}

private fun parseAssignment(
  assignment: String,
  knownVariables: Set<Variable>
): Assignment {
  check(":=" in assignment) { assignment }
  val varName = assignment.substringBefore(":=").trim()
  val variable = knownVariables.find { it.varName == varName }
    ?: throw IllegalArgumentException("Unknown variable $varName")

  val exprStr = assignment.substringAfter(":=").trim()
  val expr = guardedParseExpr(exprStr, knownVariables)
  return Assignment(variable, expr)
}

private fun TransitionJson.toTransition(knownVariables: Set<Variable>): Transition =
  Transition(
    to,
    condition?.let { guardedParseExpr(it, knownVariables) },
    assignments.orEmpty().map { parseAssignment(it, knownVariables) }
  )

fun parseAutomaton(automatonFile: File): Automaton =
  jacksonObjectMapper()
    .readValue<AutomatonJson>(automatonFile)
    .toAutomaton()