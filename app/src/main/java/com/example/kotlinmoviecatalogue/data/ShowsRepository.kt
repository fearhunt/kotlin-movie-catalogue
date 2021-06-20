package com.example.kotlinmoviecatalogue.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.kotlinmoviecatalogue.data.source.local.LocalDataSource
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.data.source.remote.ApiResponse
import com.example.kotlinmoviecatalogue.data.source.remote.RemoteDataSource
import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsDetailResponse
import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsGenresItem
import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsResponse
import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsResultsItem
import com.example.kotlinmoviecatalogue.util.AppExecutors
import com.example.kotlinmoviecatalogue.util.ArrayConverter
import com.example.kotlinmoviecatalogue.util.QueryUtils
import com.example.kotlinmoviecatalogue.vo.Resource
import java.util.*
import kotlin.collections.ArrayList

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
                        response.title,
                        response.name,
                        response.posterPath,
                        isFavorite = false
                    )

                    showsList.add(shows)
                }

                localDataSource.insertShows(showsList)
            }
        }.asLiveData()
    }

    override fun getShowsDetail(showsId: Int, showsType: String): LiveData<Resource<ShowsEntity>> {
        return object : NetworkBoundSource<ShowsEntity, ShowsDetailResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<ShowsEntity> = localDataSource.getShowsDetail(QueryUtils.getShowsDetailQuery(showsId, showsType))

            override fun shouldFetch(data: ShowsEntity?): Boolean = ((data == null) || (data.voteAverage == null))

            override fun createCall(): LiveData<ApiResponse<ShowsDetailResponse>> = remoteDataSource.getShowsDetail(showsId, showsType)

            override fun saveCallResult(data: ShowsDetailResponse) {
                val showsDetail = ShowsEntity(
                    data.id,
                    data.overview,
                    data.originalLanguage,
                    data.title,
                    data.name,
                    data.posterPath,
                    data.backdropPath,
                    data.revenue,
                    data.budget,
                    data.releaseDate,
                    data.firstAirDate,
                    data.voteAverage,
                    ArrayConverter().genresListToString(data.genres)
                )

                localDataSource.updateShowsDetail(showsDetail)
            }
        }.asLiveData()
    }

    override fun setShowsFavorite(shows: ShowsEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.updateShowsFavoriteState(shows, state) }
    }
}