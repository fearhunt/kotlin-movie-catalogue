package com.example.kotlinmoviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsGenresItem

@Entity(tableName = "showsdetailentity")
data class ShowsDetailEntity(
	@PrimaryKey
	@NonNull
	@ColumnInfo(name = "id")
	val id: Int,

	@ColumnInfo(name = "original_language")
	val originalLanguage: String,

	// Movie title
	@ColumnInfo(name = "title")
	val title: String? = null,

	// TV Show title
	@ColumnInfo(name = "name")
	val name: String? = null,

	@ColumnInfo(name = "backdrop_path")
	val backdropPath: String,

	@ColumnInfo(name = "revenue")
	val revenue: Int? = null,

	@ColumnInfo(name = "genres")
	val genres: String,

	@ColumnInfo(name = "popularity")
	val popularity: Double,

	@ColumnInfo(name = "budget")
	val budget: Int? = null,

	@ColumnInfo(name = "overview")
	val overview: String,

	@ColumnInfo(name = "poster_path")
	val posterPath: String,

	// TV Show release date
	@ColumnInfo(name = "first_air_date")
	val firstAirDate: String? = null,

	// Movie release date
	@ColumnInfo(name = "release_date")
	val releaseDate: String? = null,

	@ColumnInfo(name = "vote_average")
	val voteAverage: Double,

	@ColumnInfo(name = "tagline")
	val tagline: String,

	@ColumnInfo(name = "status")
	val status: String,

	@ColumnInfo(name = "is_favorite")
	val isFavorite: Boolean = false
)
