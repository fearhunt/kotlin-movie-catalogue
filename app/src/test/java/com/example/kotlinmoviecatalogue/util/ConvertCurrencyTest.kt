package com.example.kotlinmoviecatalogue.util

import junit.framework.TestCase

class ConvertCurrencyTest : TestCase() {
    fun testCurrencyWithCode() {
        val dummyCurrency = "$36,000,000"
        val currency = 36000000
        assertEquals(dummyCurrency, ConvertCurrency().currencyWithCode(currency, "USD"))
    }
}