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
	val id: Int,

	@ColumnInfo(name = "overview")
	val overview: String,

	@ColumnInfo(name = "original_language")
	val originalLanguage: String,

	// Movie title
	@ColumnInfo(name = "title")
	val title: String? = null,

	// TV Show title
	@ColumnInfo(name = "name")
	val name: String? = null,

	@ColumnInfo(name = "poster_path")
	val posterPath: String,

	@ColumnInfo(name = "backdrop_path")
	val backdropPath: String? = null,

	@ColumnInfo(name = "revenue")
	val revenue: Int? = null,

	@ColumnInfo(name = "budget")
	val budget: Int? = null,

	// Movie release date
	@ColumnInfo(name = "release_date")
	val releaseDate: String? = null,

	// TV Show release date
	@ColumnInfo(name = "first_air_date")
	val firstAirDate: String? = null,

	@ColumnInfo(name = "vote_average")
	val voteAverage: Double? = null,

	@ColumnInfo(name = "genres")
	val genres: String? = null,

	@ColumnInfo(name = "is_favorite")
	val isFavorite: Boolean? = false
)
