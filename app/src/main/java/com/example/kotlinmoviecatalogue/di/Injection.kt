package com.example.kotlinmoviecatalogue.di

import android.content.Context
import com.example.kotlinmoviecatalogue.data.ShowsRepository
import com.example.kotlinmoviecatalogue.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): ShowsRepository {
        val remoteDataSource = RemoteDataSource.getInstance()

        return ShowsRepository.getInstance(remoteDataSource)
    }
}