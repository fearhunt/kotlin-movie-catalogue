package com.example.kotlinmoviecatalogue.util

import androidx.sqlite.db.SimpleSQLiteQuery

object QueryUtils {
    private const val MOVIES = "movies"
    private const val TV_SHOWS = "tv_shows"

    private fun getShowsQueryStringBuilder(showsType: String): StringBuilder {
        val simpleQuery = StringBuilder().append("SELECT * FROM showsentities ")

        if (showsType == MOVIES) {
            simpleQuery.append("WHERE title IS NOT NULL ")
        } else if (showsType == TV_SHOWS) {
            simpleQuery.append("WHERE name IS NOT NULL ")
        }

        return simpleQuery
    }

    fun getShowsQuery(showsType: String): SimpleSQLiteQuery {
        return SimpleSQLiteQuery(getShowsQueryStringBuilder(showsType).toString())
    }

    fun getShowsFavoriteQuery(showsType: String): SimpleSQLiteQuery {
        val simpleQuery = getShowsQueryStringBuilder(showsType)

        simpleQuery.append("AND isFavorite = 1 ")

        return SimpleSQLiteQuery(simpleQuery.toString())
    }

    fun getShowsDetailQuery(showsId: Int, showsType: String): SimpleSQLiteQuery {
        val simpleQuery = getShowsQueryStringBuilder(showsType)

        simpleQuery.append("AND id = $showsId ")

        return SimpleSQLiteQuery(simpleQuery.toString())
    }
}