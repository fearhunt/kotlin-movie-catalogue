package com.example.kotlinmoviecatalogue.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShowsEntity(
    var title: String = "",
    var poster: String = "",
    var release_year: String = "",
    var overview: String = "",
    var score: Int = 0,
    var tags: ArrayList<String>,
    var language: String = "",
    var budget: Int?,
    var revenue: Int?
) : Parcelable
