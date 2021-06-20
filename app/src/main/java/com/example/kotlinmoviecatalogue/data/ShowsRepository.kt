package com.example.kotlinmoviecatalogue.data

import androidx.lifecycle.LiveData
import com.example.kotlinmoviecatalogue.data.source.local.LocalDataSource
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsDetailEntity
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.data.source.remote.ApiResponse
import com.example.kotlinmoviecatalogue.data.source.remote.RemoteDataSource
import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsDetailResponse
import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsResponse
import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsResultsItem
import com.example.kotlinmoviecatalogue.util.AppExecutors
import com.example.kotlinmoviecatalogue.util.QueryUtils
import com.example.kotlinmoviecatalogue.vo.Resource
import java.util.*

class ShowsRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): ShowsDataSource {
    companion object {
        @Volatile
        private var instance: ShowsRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource, appExecutors: AppExecutors): ShowsRepository =
            instance ?: synchronized(this) {
                instance ?: ShowsRepository(remoteDataSource, localDataSource, appExecutors).apply {
                    instance = this
                }
            }
    }

    override fun getShows(showsType: String): LiveData<Resource<List<ShowsEntity>>> {
        return object : NetworkBoundSource<List<ShowsEntity>, List<ShowsResultsItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<ShowsEntity>> = localDataSource.getShows(QueryUtils.getShowsQuery(showsType))

            override fun shouldFetch(data: List<ShowsEntity>?): Boolean = (data == null || data.isEmpty())

            override fun createCall(): LiveData<ApiResponse<List<ShowsResultsItem>>> = remoteDataSource.getShows(showsType)

            override fun saveCallResult(data: List<ShowsResultsItem>) {
                val showsList = ArrayList<ShowsEntity>()

                for (response in data) {
                    val shows = ShowsEntity(
                        response.id,
                        response.overview,
                        response.originalLanguage,
                        response.posterPath,
                        response.name,
                        response.title,
                        false
                    )

                    showsList.add(shows)
                }

                localDataSource.insertShows(showsList)
            }
        }.asLiveData()
    }

    override fun getShowsDetail(showsId: Int, showsType: String): LiveData<Resource<ShowsDetailEntity>> {
        return object : NetworkBoundSource<ShowsDetailEntity, ShowsDetailResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<ShowsDetailEntity> = localDataSource.getShowsDetail(QueryUtils.getShowsDetailQuery(showsId, showsType))

            override fun shouldFetch(data: ShowsDetailEntity?): Boolean = (data == null)

            override fun createCall(): LiveData<ApiResponse<ShowsDetailResponse>> = remoteDataSource.getShowsDetail(showsId, showsType)

            override fun saveCallResult(data: ShowsDetailResponse) {
                val showsDetail = ShowsDetailEntity(
                    data.id,
                    data.originalLanguage,
                    data.title,
                    data.name,
                    data.backdropPath,
                    data.revenue,
                    "testinggenres",
                    data.popularity,
                    data.budget,
                    data.overview,
                    data.posterPath,
                    data.firstAirDate,
                    data.releaseDate,
                    data.voteAverage,
                    data.tagline,
                    data.status,
                    false
                )

                localDataSource.updateShowsDetail(showsDetail)
            }
        }.asLiveData()
//        val showsDetail = MutableLiveData<ShowsDetailResponse>()
//
//        remoteDataSource.getShowsDetail(showsId, showsType, object : RemoteDataSource.LoadShowsDetailCallback {
//            override fun onDetailShowsReceived(showsDetailResponse: ShowsDetailResponse) {
//                showsDetail.postValue(showsDetailResponse)
//            }
//        })
//
//        return showsDetail
    }

    override fun setShowsFavorite(shows: ShowsResponse, isFavorite: Boolean) {
        // TODO("Not yet implemented")
    }
}