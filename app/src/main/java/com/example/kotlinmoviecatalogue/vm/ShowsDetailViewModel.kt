package com.example.kotlinmoviecatalogue.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmoviecatalogue.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.repository.MainRepository
import com.example.kotlinmoviecatalogue.response.ShowsDetailResponse
import com.example.kotlinmoviecatalogue.util.DataDummy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowsDetailViewModel : ViewModel() {
    private val _showsDetail = MutableLiveData<ShowsDetailResponse>()
    val showsDetail: LiveData<ShowsDetailResponse> = _showsDetail

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getShowsDetail(showsId: Int, showsType: String) {
        _isLoading.value = true

        val client = if (showsType == "movies") MainRepository().getMovieById(showsId) else MainRepository().getTvShowById(showsId)
        client.enqueue(object : Callback<ShowsDetailResponse> {
            override fun onResponse(call: Call<ShowsDetailResponse>, response: Response<ShowsDetailResponse>) {
                _isLoading.value = false

                if (response.isSuccessful) {
                    _showsDetail.value = response.body()
                } else {
                    Log.e("getShowsDetail", "failure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ShowsDetailResponse>, t: Throwable) {
                _isLoading.value = false

                Log.e("getShowsDetail", "failure: ${t.message}")
            }
        })
    }

//    private lateinit var showsDetail: ShowsEntity
//
//    fun getShowsDetailData(showsTitle: String?, showsType: String): ShowsEntity {
//        val list = DataDummy.generateDummy(showsType)
//
//        list.forEach { data ->
//            if (data.title == showsTitle) {
//                showsDetail = ShowsEntity(
//                    title = data.title,
//                    poster = data.poster,
//                    release_year = data.release_year,
//                    overview = data.overview,
//                    score = data.score,
//                    tags = data.tags,
//                    language = data.language,
//                    budget = data.budget,
//                    revenue = data.revenue
//                )
//            }
//        }
//
//        return showsDetail
//    }
}