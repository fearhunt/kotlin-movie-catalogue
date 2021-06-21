package com.example.kotlinmoviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsEntity

@Dao
interface ShowsDao {
    @Query("SELECT * FROM showsentities WHERE title IS NOT NULL")
    fun getMovies(): DataSource.Factory<Int, ShowsEntity>

    @Query("SELECT * FROM showsentities WHERE name IS NOT NULL")
    fun getTvShows(): DataSource.Factory<Int, ShowsEntity>

    @Query("SELECT * FROM showsentities WHERE id = :showsId")
    fun getShowsDetail(showsId: Int): LiveData<ShowsEntity>

    @Query("SELECT * FROM showsentities WHERE title IS NOT NULL AND is_favorite = 1")
    fun getMoviesFavorite(): DataSource.Factory<Int, ShowsEntity>

    @Query("SELECT * FROM showsentities WHERE name IS NOT NULL AND is_favorite = 1")
    fun getTvShowsFavorite(): DataSource.Factory<Int, ShowsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShows(shows: List<ShowsEntity>)

    @Update
    fun updateShowsDetail(showsDetail: ShowsEntity)
}