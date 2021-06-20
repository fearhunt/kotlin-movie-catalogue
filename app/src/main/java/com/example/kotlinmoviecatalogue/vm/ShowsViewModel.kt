
package com.example.kotlinmoviecatalogue.vm

import androidx.lifecycle.*
import com.example.kotlinmoviecatalogue.data.ShowsRepository
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.vo.Resource

class ShowsViewModel(private val showsRepository: ShowsRepository) : ViewModel() {
    fun getShows(showsType: String): LiveData<Resource<List<ShowsEntity>>> = showsRepository.getShows(showsType)
}