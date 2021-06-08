
package com.example.kotlinmoviecatalogue.vm

import androidx.lifecycle.*
import com.example.kotlinmoviecatalogue.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.util.DataDummy

class ShowsViewModel : ViewModel() {
    fun getShowsData(showsType: String) : List<ShowsEntity> {
        return DataDummy.generateDummy(showsType)
    }
}