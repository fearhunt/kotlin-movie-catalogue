package com.example.kotlinmoviecatalogue.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShowsEntity(
    val title: String = "",
    val poster: String = "",
    val release_year: String = "",
    val overview: String = "",
    val score: Int = 0,
    val tags: ArrayList<String>,
    val language: String = "",
    val budget: Int?,
    val revenue: Int?
) : Parcelable
