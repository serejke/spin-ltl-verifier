package ru.ctddev.verifier.expr

sealed class Value {
  abstract val type: Type

  abstract val value: Any
}

data class IntValue(override val value: Int) : Value() {
  override val type: Type
    get() = IntType

  override fun toString() = "$value"
}

data class BoolValue(override val value: Boolean) : Value() {
  override val type: Type
    get() = BoolType

  override fun toString() = "$value"
}

val TrueValue = BoolValue(true)
val FalseValue = BoolValue(false)