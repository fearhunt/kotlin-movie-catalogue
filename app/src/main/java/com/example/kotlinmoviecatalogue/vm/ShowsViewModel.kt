
package com.example.kotlinmoviecatalogue.vm

import android.util.Log
import androidx.lifecycle.*
import com.example.kotlinmoviecatalogue.data.ShowsRepository
import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsResponse

class ShowsViewModel(private val showsRepository: ShowsRepository) : ViewModel() {
    fun getShows(showsType: String): LiveData<ShowsResponse> = showsRepository.getShows(showsType)
}