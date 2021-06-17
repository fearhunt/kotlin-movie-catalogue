package com.example.kotlinmoviecatalogue.vm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.kotlinmoviecatalogue.data.ShowsRepository
import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsResponse
import com.example.kotlinmoviecatalogue.util.DataDummy
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
    private lateinit var observer: Observer<ShowsResponse>

    @Before
    fun setUp() {
        showsViewModel = ShowsViewModel(showsRepository)
    }

    @Test
    fun testGetMoviesData() {
        val showsType = "movies"
        val dummyMovies = DataDummy.generateDummy(showsType)
        val movies = MutableLiveData<ShowsResponse>()
        movies.value = dummyMovies

        `when`(showsRepository.getShows(showsType)).thenReturn(movies)
        val showsResult = showsViewModel.getShows(showsType).value
        verify<ShowsRepository>(showsRepository).getShows(showsType)
        assertNotNull(showsResult)
        assertEquals(20, showsResult?.results?.size)

        // live data test
        showsViewModel.getShows(showsType).observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun testGetTvShowsData() {
        val showsType = "tv_shows"
        val dummyTvShows = DataDummy.generateDummy(showsType)
        val tvShows = MutableLiveData<ShowsResponse>()
        tvShows.value = dummyTvShows

        `when`(showsRepository.getShows(showsType)).thenReturn(tvShows)
        val showsResult = showsViewModel.getShows(showsType).value
        verify<ShowsRepository>(showsRepository).getShows(showsType)
        assertNotNull(showsResult)
        assertEquals(20, showsResult?.results?.size)

        // live data test
        showsViewModel.getShows(showsType).observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }
}