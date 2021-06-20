package com.example.kotlinmoviecatalogue.data

import androidx.lifecycle.LiveData
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsResponse
import com.example.kotlinmoviecatalogue.vo.Resource


interface ShowsDataSource {
    fun getShows(showsType: String): LiveData<Resource<List<ShowsEntity>>>

    fun getShowsDetail(showsId: Int, showsType: String): LiveData<Resource<ShowsEntity>>

    fun setShowsFavorite(shows: ShowsResponse, isFavorite: Boolean)
}