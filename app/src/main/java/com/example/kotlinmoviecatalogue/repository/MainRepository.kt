package com.example.kotlinmoviecatalogue.repository

import com.example.kotlinmoviecatalogue.network.ApiConfig

class MainRepository {
    fun getMoviesPopular() = ApiConfig.getApiService().getMoviesPopular()

    fun getMovieById(id: Int) = ApiConfig.getApiService().getMovie(id)

    fun getTvShowsPopular() = ApiConfig.getApiService().getTvShowsPopular()

    fun getTvShowById(id: Int) = ApiConfig.getApiService().getTvShow(id)
}