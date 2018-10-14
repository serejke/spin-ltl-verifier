package ru.ctddev.verifier.conversion

import ru.ctddev.verifier.buchi.Buchi
import ru.ctddev.verifier.ltl.Ltl

fun Ltl.toBuchi(): Buchi = toGlba().toBuchi()