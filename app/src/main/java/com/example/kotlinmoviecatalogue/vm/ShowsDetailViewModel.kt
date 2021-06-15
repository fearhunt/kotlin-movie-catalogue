package com.example.kotlinmoviecatalogue.vm

import androidx.lifecycle.ViewModel
import com.example.kotlinmoviecatalogue.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.util.DataDummy

class ShowsDetailViewModel : ViewModel() {
    private lateinit var showsDetail: ShowsEntity

    fun getShowsDetailData(showsTitle: String?, showsType: String): ShowsEntity {
        val list = DataDummy.generateDummy(showsType)

        list.forEach { data ->
            if (data.title == showsTitle) {
                showsDetail = ShowsEntity(
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
            }
        }

        return showsDetail
    }
}