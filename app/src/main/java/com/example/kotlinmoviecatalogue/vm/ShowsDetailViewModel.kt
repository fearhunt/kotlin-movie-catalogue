package com.example.kotlinmoviecatalogue.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmoviecatalogue.data.ShowsRepository
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.vo.Resource

class ShowsDetailViewModel(private val showsRepository: ShowsRepository) : ViewModel() {
    private lateinit var showsDetail: LiveData<Resource<ShowsEntity>>

    fun getShowsDetail(showsId: Int, showsType: String): LiveData<Resource<ShowsEntity>> {
        showsDetail = showsRepository.getShowsDetail(showsId, showsType)

        return showsDetail
    }

    fun setFavorite() {
        val showsDetailResource = showsDetail.value
        val newState = !(showsDetailResource?.data?.isFavorite!!)

        showsRepository.setShowsFavorite(showsDetailResource.data, newState)
    }
}