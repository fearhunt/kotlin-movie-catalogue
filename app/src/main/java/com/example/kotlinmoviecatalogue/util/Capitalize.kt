package com.example.kotlinmoviecatalogue.util

class Capitalize {
    fun capitalizeEachWord(words: String): String? {
        var capitalizedWords = ""
        val tempWords = words.split(" ")

        tempWords.forEach {
            capitalizedWords += it.capitalize() + " "
        }

        return capitalizedWords.trimEnd()
    }
}