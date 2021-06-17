package com.example.kotlinmoviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinmoviecatalogue.data.source.remote.RemoteDataSource
import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsDetailResponse
import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsResponse

class FakeShowsRepository (private val remoteDataSource: RemoteDataSource): ShowsDataSource {
    override fun getShows(showsType: String): LiveData<ShowsResponse> {
        val shows = MutableLiveData<ShowsResponse>()

        remoteDataSource.getShows(showsType, object : RemoteDataSource.LoadShowsCallback {
            override fun onAllShowsReceived(showsResponse: ShowsResponse) {
                shows.postValue(showsResponse)
            }
        })

        return shows
    }

    override fun getShowsDetail(showsId: Int, showsType: String): LiveData<ShowsDetailResponse> {
        val showsDetail = MutableLiveData<ShowsDetailResponse>()

        remoteDataSource.getShowsDetail(showsId, showsType, object : RemoteDataSource.LoadShowsDetailCallback {
            override fun onDetailShowsReceived(showsDetailResponse: ShowsDetailResponse) {
                showsDetail.postValue(showsDetailResponse)
            }
        })

        return showsDetail
    }
}