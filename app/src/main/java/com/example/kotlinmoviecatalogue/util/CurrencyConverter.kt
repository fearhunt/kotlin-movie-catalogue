package com.example.kotlinmoviecatalogue.util

import java.text.NumberFormat
import java.util.*

class CurrencyConverter {
    fun currencyWithCode(number: Int?, currencyCode: String): String {
        val currencyInstance = NumberFormat.getCurrencyInstance()
        currencyInstance.maximumFractionDigits = 0
        currencyInstance.currency = Currency.getInstance(currencyCode)

        return currencyInstance.format(number)
    }
}
