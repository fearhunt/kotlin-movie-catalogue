
package com.example.kotlinmoviecatalogue.vm

import android.util.Log
import androidx.lifecycle.*
import com.example.kotlinmoviecatalogue.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.repository.MainRepository
import com.example.kotlinmoviecatalogue.response.ShowResultsItem
import com.example.kotlinmoviecatalogue.response.ShowsResponse
import com.example.kotlinmoviecatalogue.util.DataDummy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowsViewModel : ViewModel() {
    private val _listShow = MutableLiveData<List<ShowResultsItem>>()
    val listShow: LiveData<List<ShowResultsItem>> = _listShow

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getShows(showsType: String) {
        _isLoading.value = true

        val client = if (showsType == "movies") MainRepository().getMoviesPopular() else MainRepository().getTvShowsPopular()
        client.enqueue(object : Callback<ShowsResponse> {
            override fun onResponse(call: Call<ShowsResponse>, response: Response<ShowsResponse>) {
                _isLoading.value = false

                if (response.isSuccessful) {
                    _listShow.value = response.body()?.results
                } else {
                    Log.e("getShows", "failure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ShowsResponse>, t: Throwable) {
                _isLoading.value = false

                Log.e("getShows", "failure: ${t.message}")
            }
        })
    }

//    fun getShowsData(showsType: String) : List<ShowsEntity>  {
//        return DataDummy.generateDummy((showsType))
//    }
}