package com.example.kotlinmoviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ShowsResponse(

	@field:SerializedName("results")
	val results: List<ShowsResultsItem>,

	@field:SerializedName("total_results")
	val totalResults: Int
)

data class ShowsResultsItem(

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("original_language")
	val originalLanguage: String,

	@field:SerializedName("poster_path")
	val posterPath: String,

	// TV Show title
	@field:SerializedName("name")
	val name: String? = null,

	// Movie title
	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("id")
	val id: Int
)
