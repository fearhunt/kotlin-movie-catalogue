package com.example.kotlinmoviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsDetailEntity
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.data.source.local.room.ShowsDao

class LocalDataSource private constructor(private val showsDao: ShowsDao) {
    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(showsDao: ShowsDao): LocalDataSource =
            instance ?: LocalDataSource(showsDao)
    }

    fun getShows(query: SimpleSQLiteQuery): LiveData<List<ShowsEntity>> = showsDao.getShows(query)

    fun getShowsFavorite(query: SimpleSQLiteQuery): LiveData<List<ShowsEntity>> = showsDao.getShowsFavorite(query)

    fun getShowsDetail(query: SimpleSQLiteQuery): LiveData<ShowsDetailEntity> = showsDao.getShowsDetail(query)

    fun insertShows(shows: List<ShowsEntity>) = showsDao.insertShows(shows)

    fun deleteShows(shows: ShowsEntity) = showsDao.deleteShows(shows)

    fun updateShowsDetail(showsDetail: ShowsDetailEntity) = showsDao.updateShowsDetail(showsDetail)
}