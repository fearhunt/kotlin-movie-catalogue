package com.example.kotlinmoviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.vo.Resource


interface ShowsDataSource {
    fun getShows(showsType: String): LiveData<Resource<PagedList<ShowsEntity>>>

    fun getShowsDetail(showsId: Int, showsType: String): LiveData<Resource<ShowsEntity>>

    fun setShowsFavorite(shows: ShowsEntity, state: Boolean)

    fun getShowsFavorite(showsType: String): LiveData<PagedList<ShowsEntity>>
}