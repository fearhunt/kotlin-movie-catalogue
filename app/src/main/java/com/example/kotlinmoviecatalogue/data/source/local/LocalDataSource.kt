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

    fun getShows(query: SimpleSQLiteQuery): DataSource.Factory<Int, ShowsEntity> = showsDao.getShows(query)

    fun getShowsFavorite(query: SimpleSQLiteQuery): DataSource.Factory<Int, ShowsEntity> = showsDao.getShowsFavorite(query)

    fun getShowsDetail(query: SimpleSQLiteQuery): LiveData<ShowsEntity> = showsDao.getShowsDetail(query)

    fun insertShows(shows: List<ShowsEntity>) = showsDao.insertShows(shows)

    fun updateShowsDetail(showsDetail: ShowsEntity) = showsDao.updateShowsDetail(showsDetail)

    fun updateShowsFavoriteState(shows: ShowsEntity, newState: Boolean) {
        shows.isFavorite = newState
        showsDao.updateShowsDetail(shows)
    }
}