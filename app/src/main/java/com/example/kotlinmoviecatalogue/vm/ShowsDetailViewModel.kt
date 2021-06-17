package com.example.kotlinmoviecatalogue.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmoviecatalogue.data.ShowsRepository
import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsDetailResponse

class ShowsDetailViewModel(private val showsRepository: ShowsRepository) : ViewModel() {
    fun getShowsDetail(showsId: Int, showsType: String): LiveData<ShowsDetailResponse> = showsRepository.getShowsDetail(showsId, showsType)
}