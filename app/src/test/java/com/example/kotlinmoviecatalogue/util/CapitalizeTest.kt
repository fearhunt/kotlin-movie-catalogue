package com.example.kotlinmoviecatalogue.util

import junit.framework.TestCase

class CapitalizeTest : TestCase() {
    fun testCapitalizeEachWord() {
        val dummyWords = "the brown fox jumps over the lazy dog"
        val capitalizedWords = "The Brown Fox Jumps Over The Lazy Dog"
        assertEquals(capitalizedWords, Capitalize().capitalizeEachWord(dummyWords))
    }
}