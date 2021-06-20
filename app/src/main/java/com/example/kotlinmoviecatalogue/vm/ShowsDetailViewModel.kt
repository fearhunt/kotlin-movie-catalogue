package com.example.kotlinmoviecatalogue.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmoviecatalogue.data.ShowsRepository
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.vo.Resource

class ShowsDetailViewModel(private val showsRepository: ShowsRepository) : ViewModel() {
    fun getShowsDetail(showsId: Int, showsType: String): LiveData<Resource<ShowsEntity>> = showsRepository.getShowsDetail(showsId, showsType)
}