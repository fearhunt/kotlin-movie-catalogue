package com.example.kotlinmoviecatalogue.response

import com.google.gson.annotations.SerializedName

data class ShowsResponse(

	@field:SerializedName("results")
	val results: List<ShowResultsItem>,

	@field:SerializedName("total_results")
	val totalResults: Int
)

data class ShowResultsItem(

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("original_language")
	val originalLanguage: String,

	@field:SerializedName("poster_path")
	val posterPath: String,

	@field:SerializedName("original_name")
	val originalName: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,
)
