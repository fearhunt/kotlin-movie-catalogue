package com.example.kotlinmoviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsEntity

@Dao
interface ShowsDao {
    @RawQuery(observedEntities = [ShowsEntity::class])
    fun getShows(query: SupportSQLiteQuery): DataSource.Factory<Int, ShowsEntity>

    @RawQuery(observedEntities = [ShowsEntity::class])
    fun getShowsFavorite(query: SupportSQLiteQuery): DataSource.Factory<Int, ShowsEntity>

    @RawQuery(observedEntities = [ShowsEntity::class])
    fun getShowsDetail(query: SupportSQLiteQuery): LiveData<ShowsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShows(shows: List<ShowsEntity>)

    @Update
    fun updateShowsDetail(showsDetail: ShowsEntity)
}