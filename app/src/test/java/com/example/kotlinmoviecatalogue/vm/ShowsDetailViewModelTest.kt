package com.example.kotlinmoviecatalogue.vm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.kotlinmoviecatalogue.data.ShowsRepository
import com.example.kotlinmoviecatalogue.data.source.remote.response.ShowsDetailResponse
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
class ShowsDetailViewModelTest {
    private lateinit var showsDetailViewModel: ShowsDetailViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var showsRepository: ShowsRepository

    @Mock
    private lateinit var observer: Observer<ShowsDetailResponse>

    @Before
    fun setUp() {
        showsDetailViewModel = ShowsDetailViewModel(showsRepository)
    }

    @Test
    fun testGetMovieDetailData() {
        val showsType = "movies"
        val dummyMovieDetail = DataDummy.generateDetailDummy("movies")
        val movieDetail = MutableLiveData<ShowsDetailResponse>()
        movieDetail.value = dummyMovieDetail

        `when`(showsRepository.getShowsDetail(dummyMovieDetail.id, showsType)).thenReturn(movieDetail)
        val showsDetailResult = showsDetailViewModel.getShowsDetail(dummyMovieDetail.id, showsType).value as ShowsDetailResponse
        verify<ShowsRepository>(showsRepository).getShowsDetail(dummyMovieDetail.id, showsType)
        assertNotNull(showsDetailResult)
        assertEquals(dummyMovieDetail.originalLanguage, showsDetailResult.originalLanguage)
        assertEquals(dummyMovieDetail.title, showsDetailResult.title)
        assertEquals(dummyMovieDetail.name, showsDetailResult.name)
        assertEquals(dummyMovieDetail.backdropPath, showsDetailResult.backdropPath)
        assertEquals(dummyMovieDetail.revenue, showsDetailResult.revenue)
        assertEquals(dummyMovieDetail.genres, showsDetailResult.genres)
        assertEquals(dummyMovieDetail.popularity, showsDetailResult.popularity, 0.001)
        assertEquals(dummyMovieDetail.id, showsDetailResult.id)
        assertEquals(dummyMovieDetail.budget, showsDetailResult.budget)
        assertEquals(dummyMovieDetail.overview, showsDetailResult.overview)
        assertEquals(dummyMovieDetail.posterPath, showsDetailResult.posterPath)
        assertEquals(dummyMovieDetail.firstAirDate, showsDetailResult.firstAirDate)
        assertEquals(dummyMovieDetail.releaseDate, showsDetailResult.releaseDate)
        assertEquals(dummyMovieDetail.voteAverage, showsDetailResult.voteAverage, 0.001)
        assertEquals(dummyMovieDetail.tagline, showsDetailResult.tagline)
        assertEquals(dummyMovieDetail.status, showsDetailResult.status)

        // live data test
        showsDetailViewModel.getShowsDetail(dummyMovieDetail.id, showsType).observeForever(observer)
        verify(observer).onChanged(dummyMovieDetail)
    }

    @Test
    fun testGetTvShowsDetailData() {
        val showsType = "tv_shows"
        val dummyTvShowsDetail = DataDummy.generateDetailDummy("tv_shows")
        val tvShowsDetail = MutableLiveData<ShowsDetailResponse>()
        tvShowsDetail.value = dummyTvShowsDetail

        `when`(showsRepository.getShowsDetail(dummyTvShowsDetail.id, showsType)).thenReturn(tvShowsDetail)
        val showsDetailResult = showsDetailViewModel.getShowsDetail(dummyTvShowsDetail.id, showsType).value as ShowsDetailResponse
        verify<ShowsRepository>(showsRepository).getShowsDetail(dummyTvShowsDetail.id, showsType)
        assertNotNull(showsDetailResult)
        assertEquals(dummyTvShowsDetail.originalLanguage, showsDetailResult.originalLanguage)
        assertEquals(dummyTvShowsDetail.title, showsDetailResult.title)
        assertEquals(dummyTvShowsDetail.name, showsDetailResult.name)
        assertEquals(dummyTvShowsDetail.backdropPath, showsDetailResult.backdropPath)
        assertEquals(dummyTvShowsDetail.revenue, showsDetailResult.revenue)
        assertEquals(dummyTvShowsDetail.genres, showsDetailResult.genres)
        assertEquals(dummyTvShowsDetail.popularity, showsDetailResult.popularity, 0.001)
        assertEquals(dummyTvShowsDetail.id, showsDetailResult.id)
        assertEquals(dummyTvShowsDetail.budget, showsDetailResult.budget)
        assertEquals(dummyTvShowsDetail.overview, showsDetailResult.overview)
        assertEquals(dummyTvShowsDetail.posterPath, showsDetailResult.posterPath)
        assertEquals(dummyTvShowsDetail.firstAirDate, showsDetailResult.firstAirDate)
        assertEquals(dummyTvShowsDetail.releaseDate, showsDetailResult.releaseDate)
        assertEquals(dummyTvShowsDetail.voteAverage, showsDetailResult.voteAverage, 0.001)
        assertEquals(dummyTvShowsDetail.tagline, showsDetailResult.tagline)
        assertEquals(dummyTvShowsDetail.status, showsDetailResult.status)

        // live data test
        showsDetailViewModel.getShowsDetail(dummyTvShowsDetail.id, showsType).observeForever(observer)
        verify(observer).onChanged(dummyTvShowsDetail)
    }
}