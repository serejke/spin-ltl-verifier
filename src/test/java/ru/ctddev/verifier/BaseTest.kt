package ru.ctddev.verifier

import java.io.File

abstract class BaseTest {
  fun getTestDataFile(path: String): File =
    File(this.javaClass.getResource(path).file)
}