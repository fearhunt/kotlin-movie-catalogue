package com.example.kotlinmoviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ShowsDetailResponse(
	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("original_language")
	val originalLanguage: String,

	// Movie title
	@field:SerializedName("title")
	val title: String? = null,

	// TV Show title
	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("backdrop_path")
	val backdropPath: String,

	@field:SerializedName("revenue")
	val revenue: Int? = null,

	@field:SerializedName("genres")
	val genres: List<ShowsGenresItem>,

	@field:SerializedName("budget")
	val budget: Int? = null,

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("poster_path")
	val posterPath: String,

	// TV Show release date
	@field:SerializedName("first_air_date")
	val firstAirDate: String? = null,

	// Movie release date
	@field:SerializedName("release_date")
	val releaseDate: String? = null,

	@field:SerializedName("vote_average")
	val voteAverage: Double,
)

data class ShowsGenresItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
)
