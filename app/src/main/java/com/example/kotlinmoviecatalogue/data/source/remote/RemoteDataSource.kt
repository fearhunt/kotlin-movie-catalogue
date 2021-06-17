package com.example.kotlinmoviecatalogue.data.source.remote

import android.util.Log
import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsDetailResponse
import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsResponse
import com.example.kotlinmoviecatalogue.network.ApiConfig
import com.example.kotlinmoviecatalogue.util.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    fun getShows(showsType: String, callback: LoadShowsCallback) {
        EspressoIdlingResource.increment()

        val client = if (showsType == "movies") ApiConfig.getApiService().getMoviesPopular() else ApiConfig.getApiService().getTvShowsPopular()
        client.enqueue(object : Callback<ShowsResponse> {
            override fun onResponse(call: Call<ShowsResponse>, response: Response<ShowsResponse>) {
                if (response.isSuccessful) {
                    val res = response.body() // call results
                    res?.let { callback.onAllShowsReceived(it) }
                } else {
                    Log.e("getShows", "failure: ${response.message()}")
                }

                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<ShowsResponse>, t: Throwable) {
                Log.e("getShows", "failure: ${t.message}")

                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getShowsDetail(showsId: Int, showsType: String, callback: LoadShowsDetailCallback) {
        EspressoIdlingResource.increment()

        val client = if (showsType == "movies") ApiConfig.getApiService().getMovie(showsId) else ApiConfig.getApiService().getTvShow(showsId)
        client.enqueue(object : Callback<ShowsDetailResponse> {
            override fun onResponse(call: Call<ShowsDetailResponse>, response: Response<ShowsDetailResponse>) {
                if (response.isSuccessful) {
                    val res = response.body()
                    res?.let { callback.onDetailShowsReceived(it) }
                } else {
                    Log.e("getShowsDetail", "failure: ${response.message()}")
                }

                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<ShowsDetailResponse>, t: Throwable) {
                Log.e("getShowsDetail", "failure: ${t.message}")

                EspressoIdlingResource.decrement()
            }
        })
    }

    interface LoadShowsCallback {
        fun onAllShowsReceived(showsResponse: ShowsResponse)
    }

    interface LoadShowsDetailCallback {
        fun onDetailShowsReceived(showsDetailResponse: ShowsDetailResponse)
    }
}
