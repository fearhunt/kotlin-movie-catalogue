package com.example.kotlinmoviecatalogue.network

import com.example.kotlinmoviecatalogue.data.source.remote.response.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("movie/popular")
    fun getMoviesPopular(): Call<ShowsResponse>

    @GET("movie/{id}")
    fun getMovie(
        @Path("id") id: Int
    ): Call<ShowsDetailResponse>

    @GET("tv/popular")
    fun getTvShowsPopular(): Call<ShowsResponse>

    @GET("tv/{id}")
    fun getTvShow(
        @Path("id") id: Int
    ): Call<ShowsDetailResponse>
}