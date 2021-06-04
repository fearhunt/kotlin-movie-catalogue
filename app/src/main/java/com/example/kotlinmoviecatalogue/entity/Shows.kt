package com.example.kotlinmoviecatalogue.entity

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Shows (
    var title: String = "",
    var poster: String = "",
    var release_year: String = "",
    var overview: String = "",
    var score: Int = 0,
    var tags: Array<String>,
    var language: String = "",
    var budget: Int?,
    var revenue: Int?
) : Parcelable
