package com.example.kotlinmoviecatalogue.vm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.kotlinmoviecatalogue.data.ShowsRepository
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.util.DataDummy
import com.example.kotlinmoviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ShowsViewModelTest {
    private lateinit var showsViewModel: ShowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var showsRepository: ShowsRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<ShowsEntity>>>

    @Mock
    private lateinit var favoriteObserver: Observer<PagedList<ShowsEntity>>

    @Mock
    private lateinit var pagedList: PagedList<ShowsEntity>

    @Before
    fun setUp() {
        showsViewModel = ShowsViewModel(showsRepository)
    }

    @Test
    fun testGetMoviesData() = getShowsData("movies")

    @Test
    fun testGetTvShowsData() = getShowsData("tv_shows")

    @Test
    fun testGetMoviesFavoriteData() = getShowsFavoriteData("movies")

    @Test
    fun testGetTvShowsFavoriteData() = getShowsFavoriteData("tv_shows")

    private fun getShowsData(showsType: String) {
        val dummyShows = Resource.success(pagedList)
        `when`(dummyShows.data?.size).thenReturn(4)

        val shows = MutableLiveData<Resource<PagedList<ShowsEntity>>>()
        shows.value = dummyShows
        `when`(showsRepository.getShows(showsType)).thenReturn(shows)
        val showsResult = showsViewModel.getShows(showsType).value?.data
        verify(showsRepository).getShows(showsType)
        assertNotNull(showsResult)
        assertEquals(4, showsResult?.size)

        // live data test
        showsViewModel.getShows(showsType).observeForever(observer)
        verify(observer).onChanged(dummyShows)
    }

    private fun getShowsFavoriteData(showsType: String) {
        val dummyShows = pagedList
        `when`(dummyShows.size).thenReturn(4)

        val shows = MutableLiveData<PagedList<ShowsEntity>>()
        shows.value = dummyShows
        `when`(showsRepository.getShowsFavorite(showsType)).thenReturn(shows)
        val showsResult = showsViewModel.getShowsFavorite(showsType).value
        verify(showsRepository).getShowsFavorite(showsType)
        assertNotNull(showsResult)
        assertEquals(4, showsResult?.size)

        // live data test
        showsViewModel.getShowsFavorite(showsType).observeForever(favoriteObserver)
        verify(favoriteObserver).onChanged(dummyShows)
    }
}