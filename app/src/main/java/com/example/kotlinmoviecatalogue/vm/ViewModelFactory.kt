package com.example.kotlinmoviecatalogue.vm

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinmoviecatalogue.data.ShowsRepository
import com.example.kotlinmoviecatalogue.di.Injection

class ViewModelFactory private constructor(private val mShowsRepository: ShowsRepository) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                ViewModelFactory(Injection.provideRepository(context)).apply { instance = this }
            }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ShowsViewModel::class.java) -> {
                ShowsViewModel(mShowsRepository) as T
            }
            modelClass.isAssignableFrom(ShowsDetailViewModel::class.java) -> {
                ShowsDetailViewModel(mShowsRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}