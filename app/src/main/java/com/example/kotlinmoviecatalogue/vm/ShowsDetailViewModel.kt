package com.example.kotlinmoviecatalogue.vm

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmoviecatalogue.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.util.DataDummy
import com.example.kotlinmoviecatalogue.util.ReadJsonAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ShowsDetailViewModel : ViewModel() {
    private val showsDetail = MutableLiveData<ShowsEntity>()

//    fun setShowsDetailData(showsTitle: String?, showsType: String, context: FragmentActivity?) {
//        val jsonFileString = context?.let { ReadJsonAsset().getJsonDataFromAsset(it, "$showsType.json") }
//
//        val gson = Gson()
//        val listJsonData = object : TypeToken<List<ShowsEntity>>() {}.type
//        val showsList: List<ShowsEntity> = gson.fromJson(jsonFileString, listJsonData)
//
//        showsList.forEach { data ->
//            if (data.title == showsTitle) {
//                val shows = ShowsEntity(
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
//
//                this.showsDetail.postValue(shows)
//                return
//            }
//        }
//    }
//
//    fun getShowsDetailData(): LiveData<ShowsEntity> {
//        return showsDetail
//    }

    fun setShowsDetailData(showsTitle: String?, showsType: String) {
        val list: ArrayList<ShowsEntity> = arrayListOf()

        list.addAll(DataDummy.generateDummy(showsType))

        list.forEach { data ->
            if (data.title == showsTitle) {
                val shows = ShowsEntity(
                    title = data.title,
                    poster = data.poster,
                    release_year = data.release_year,
                    overview = data.overview,
                    score = data.score,
                    tags = data.tags,
                    language = data.language,
                    budget = data.budget,
                    revenue = data.revenue
                )

                this.showsDetail.postValue(shows)
                return
            }
        }
    }

    fun getShowsDetailData(): LiveData<ShowsEntity> {
        return showsDetail
    }
}