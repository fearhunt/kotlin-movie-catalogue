
package com.example.kotlinmoviecatalogue.vm

import android.util.Log
import androidx.lifecycle.*
import com.example.kotlinmoviecatalogue.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.repository.MainRepository
import com.example.kotlinmoviecatalogue.response.MovieResultsItem
import com.example.kotlinmoviecatalogue.response.MoviesResponse
import com.example.kotlinmoviecatalogue.util.DataDummy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowsViewModel : ViewModel() {
    private val _listMovie = MutableLiveData<List<MovieResultsItem>>()
    val listMovie: LiveData<List<MovieResultsItem>> = _listMovie

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getAllMovies() {
        _isLoading.value = true

        val client = MainRepository().getMoviesPopular()
        client.enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                _isLoading.value = false

                if (response.isSuccessful) {
                    _listMovie.value = response.body()?.results
                } else {
                    Log.e("getAllMovies", "failure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                _isLoading.value = false

                Log.e("getAllMovies", "failure: ${t.message}")
            }
        })
    }

    fun getShowsData(showsType: String) : List<ShowsEntity>  {
        return DataDummy.generateDummy((showsType))
    }
}