package com.example.kotlinmoviecatalogue.di

import android.content.Context
import com.example.kotlinmoviecatalogue.data.ShowsRepository
import com.example.kotlinmoviecatalogue.data.source.local.LocalDataSource
import com.example.kotlinmoviecatalogue.data.source.local.room.ShowsDatabase
import com.example.kotlinmoviecatalogue.data.source.remote.RemoteDataSource
import com.example.kotlinmoviecatalogue.util.AppExecutors

object Injection {
    fun provideRepository(context: Context): ShowsRepository {
        val database = ShowsDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.showsDao())
        val appExecutors = AppExecutors()

        return ShowsRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}