package com.example.kotlinmoviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "showsentities")
data class ShowsEntity(
	@PrimaryKey
	@NonNull
	@ColumnInfo(name = "id")
	var id: Int,

	@ColumnInfo(name = "overview")
	var overview: String,

	@ColumnInfo(name = "original_language")
	var originalLanguage: String,

	// Movie title
	@ColumnInfo(name = "title")
	var title: String? = null,

	// TV Show title
	@ColumnInfo(name = "name")
	var name: String? = null,

	@ColumnInfo(name = "poster_path")
	var posterPath: String,

	@ColumnInfo(name = "backdrop_path")
	var backdropPath: String? = null,

	@ColumnInfo(name = "revenue")
	var revenue: Int? = null,

	@ColumnInfo(name = "budget")
	var budget: Int? = null,

	// Movie release date
	@ColumnInfo(name = "release_date")
	var releaseDate: String? = null,

	// TV Show release date
	@ColumnInfo(name = "first_air_date")
	var firstAirDate: String? = null,

	@ColumnInfo(name = "vote_average")
	var voteAverage: Double? = null,

	@ColumnInfo(name = "genres")
	var genres: String? = null,

	@ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean? = false
)
