package com.example.kotlinmoviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsEntity

@Dao
interface ShowsDao {
    @RawQuery(observedEntities = [ShowsEntity::class])
    fun getShows(query: SupportSQLiteQuery): LiveData<List<ShowsEntity>> // TODO valuate to DataSource.Factory

    @RawQuery(observedEntities = [ShowsEntity::class])
    fun getShowsFavorite(query: SupportSQLiteQuery): LiveData<List<ShowsEntity>> // TODO valuate to DataSource.factory

    @RawQuery(observedEntities = [ShowsEntity::class])
    fun getShowsDetail(query: SupportSQLiteQuery): LiveData<ShowsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShows(shows: List<ShowsEntity>)

    @Delete
    fun deleteShows(shows: ShowsEntity)

    @Update
    fun updateShowsDetail(showsDetail: ShowsEntity)
}