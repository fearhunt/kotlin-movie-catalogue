
package com.example.kotlinmoviecatalogue.vm

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*
import com.example.kotlinmoviecatalogue.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.util.ReadJsonAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ShowsViewModel : ViewModel() {
    private val shows = MutableLiveData<ArrayList<ShowsEntity>>()
    private val isLoading = MutableLiveData<Boolean>()

    fun setShowsData(showsType: String, context: FragmentActivity?) {
        val list: ArrayList<ShowsEntity> = arrayListOf()

        val jsonFileString = context?.let { ReadJsonAsset().getJsonDataFromAsset(it, "$showsType.json") }

        val gson = Gson()
        val listJsonData = object : TypeToken<List<ShowsEntity>>() {}.type
        val showsList: List<ShowsEntity> = gson.fromJson(jsonFileString, listJsonData)
        showsList.forEach { data ->
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

            list.add(shows)
        }

        shows.postValue(list)
    }

    fun getShowsData(): LiveData<ArrayList<ShowsEntity>> {
        return shows
    }

    fun getLoadingStatus(): LiveData<Boolean> {
        return isLoading
    }
}