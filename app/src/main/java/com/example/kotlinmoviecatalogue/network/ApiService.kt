package com.example.kotlinmoviecatalogue.network

import com.example.kotlinmoviecatalogue.response.MovieDetailResponse
import com.example.kotlinmoviecatalogue.response.MoviesResponse
import com.example.kotlinmoviecatalogue.response.TvShowsDetailResponse
import com.example.kotlinmoviecatalogue.response.TvShowsResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("movie/popular")
    fun getMoviesPopular(): Call<MoviesResponse>

    @GET("movie/{id}")
    fun getMovie(
        @Path("id") id: String
    ): Call<MovieDetailResponse>

    @GET("tv/popular")
    fun getTvShowsPopular(): Call<TvShowsResponse>

    @GET("tv/{id}")
    fun getTvShow(
        @Path("id") id: String
    ): Call<TvShowsDetailResponse>
}