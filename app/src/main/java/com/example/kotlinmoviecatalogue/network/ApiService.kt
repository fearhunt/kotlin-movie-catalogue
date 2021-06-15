package com.example.kotlinmoviecatalogue.network

import com.example.kotlinmoviecatalogue.response.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("movie/popular")
    fun getMoviesPopular(): Call<ShowsResponse>

    @GET("movie/{id}")
    fun getMovie(
        @Path("id") id: String
    ): Call<MovieDetailResponse>

    @GET("tv/popular")
    fun getTvShowsPopular(): Call<ShowsResponse>

    @GET("tv/{id}")
    fun getTvShow(
        @Path("id") id: String
    ): Call<TvShowsDetailResponse>
}