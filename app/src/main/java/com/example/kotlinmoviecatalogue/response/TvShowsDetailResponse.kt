package com.example.kotlinmoviecatalogue.response

import com.google.gson.annotations.SerializedName

data class TvShowsDetailResponse(

	@field:SerializedName("original_language")
	val originalLanguage: String,

	@field:SerializedName("number_of_episodes")
	val numberOfEpisodes: Int,

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("backdrop_path")
	val backdropPath: String,

	@field:SerializedName("genres")
	val genres: List<TvShowGenresItem>,

	@field:SerializedName("popularity")
	val popularity: Double,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("number_of_seasons")
	val numberOfSeasons: Int,

	@field:SerializedName("vote_count")
	val voteCount: Int,

	@field:SerializedName("first_air_date")
	val firstAirDate: String,

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("languages")
	val languages: List<String>,

	@field:SerializedName("poster_path")
	val posterPath: String,

	@field:SerializedName("origin_country")
	val originCountry: List<String>,

	@field:SerializedName("spoken_languages")
	val spokenLanguages: List<TvShowSpokenLanguagesItem>,

	@field:SerializedName("original_name")
	val originalName: String,

	@field:SerializedName("vote_average")
	val voteAverage: Double,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("tagline")
	val tagline: String,

	@field:SerializedName("episode_run_time")
	val episodeRunTime: List<Int>,

	@field:SerializedName("in_production")
	val inProduction: Boolean,

	@field:SerializedName("last_air_date")
	val lastAirDate: String,

	@field:SerializedName("homepage")
	val homepage: String,

	@field:SerializedName("status")
	val status: String
)

data class TvShowGenresItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
)

data class TvShowSpokenLanguagesItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("iso_639_1")
	val iso6391: String,

	@field:SerializedName("english_name")
	val englishName: String
)