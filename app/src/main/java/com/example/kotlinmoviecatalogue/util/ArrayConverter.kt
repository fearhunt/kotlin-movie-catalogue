package com.example.kotlinmoviecatalogue.util

import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsGenresItem

class ArrayConverter {
    fun genresListToString(list: List<ShowsGenresItem>): String {
        var convertedString = ""

        list.forEachIndexed { index, tag ->
            convertedString += tag.name

            if (index < (list.size - 1)) {
                convertedString += ", "
            }
        }

        return convertedString
    }
}