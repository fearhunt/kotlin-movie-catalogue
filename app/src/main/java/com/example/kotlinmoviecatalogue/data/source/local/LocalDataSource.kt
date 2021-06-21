package com.example.kotlinmoviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.data.source.local.room.ShowsDao

class LocalDataSource private constructor(private val showsDao: ShowsDao) {
    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(showsDao: ShowsDao): LocalDataSource =
            instance ?: LocalDataSource(showsDao)
    }

    fun getShows(showsType: String): DataSource.Factory<Int, ShowsEntity> = if (showsType == "movies") showsDao.getMovies() else showsDao.getTvShows()

    fun getShowsFavorite(showsType: String): DataSource.Factory<Int, ShowsEntity> = if (showsType == "movies") showsDao.getMoviesFavorite() else showsDao.getTvShowsFavorite()

    fun getShowsDetail(showsId: Int): LiveData<ShowsEntity> = showsDao.getShowsDetail(showsId)

    fun insertShows(shows: List<ShowsEntity>) = showsDao.insertShows(shows)

    fun updateShowsDetail(showsDetail: ShowsEntity) = showsDao.updateShowsDetail(showsDetail)

    fun updateShowsFavoriteState(shows: ShowsEntity, newState: Boolean) {
        shows.isFavorite = newState
        showsDao.updateShowsDetail(shows)
    }
}