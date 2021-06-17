package com.example.kotlinmoviecatalogue.data

import androidx.lifecycle.LiveData
import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsDetailResponse
import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsResponse


interface ShowsDataSource {
    fun getShows(showsType: String): LiveData<ShowsResponse>

    fun getShowsDetail(showsId: Int, showsType: String): LiveData<ShowsDetailResponse>
}