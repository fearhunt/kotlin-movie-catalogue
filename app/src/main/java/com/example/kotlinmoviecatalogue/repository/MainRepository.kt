package com.example.kotlinmoviecatalogue.repository

import com.example.kotlinmoviecatalogue.network.ApiConfig

class MainRepository {
    fun getMoviesPopular() = ApiConfig.getApiService().getMoviesPopular()

    fun getMovieById(id: String) = ApiConfig.getApiService().getMovie(id)

    fun getTvShowsPopular() = ApiConfig.getApiService().getTvShowsPopular()

    fun getTvShowById(id: String) = ApiConfig.getApiService().getTvShow(id)
}