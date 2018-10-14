package ru.ctddev.verifier.expr

sealed class Type

object IntType : Type() {
  override fun toString() = "int"
}

object BoolType : Type() {
  override fun toString() = "bool"
}