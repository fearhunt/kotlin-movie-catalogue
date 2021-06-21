package com.example.kotlinmoviecatalogue.vm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.kotlinmoviecatalogue.data.ShowsRepository
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.util.DataDummy
import com.example.kotlinmoviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
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
    private lateinit var observer: Observer<Resource<ShowsEntity>>

    @Before
    fun setUp() {
        showsDetailViewModel = ShowsDetailViewModel(showsRepository)
    }

    @Test
    fun testGetMovieDetailData() {
        val showsType = "movies"
        val dummyMovieDetail = Resource.success(DataDummy.generateDetailDummy(showsType))
        val movieDetail = MutableLiveData<Resource<ShowsEntity>>()
        movieDetail.value = dummyMovieDetail

        `when`(dummyMovieDetail.data?.let { showsRepository.getShowsDetail(it.id, showsType) }).thenReturn(movieDetail)
        val showsDetailResult = dummyMovieDetail.data?.let { showsDetailViewModel.getShowsDetail(it.id, showsType).value }
        dummyMovieDetail.data?.let { verify(showsRepository).getShowsDetail(it.id, showsType) }
        assertNotNull(showsDetailResult)

        // live data test
        dummyMovieDetail.data?.let { showsDetailViewModel.getShowsDetail(it.id, showsType).observeForever(observer) }
        verify(observer).onChanged(dummyMovieDetail)
    }

    @Test
    fun testGetTvShowsDetailData() {
        val showsType = "tv_shows"
        val dummyTvShowsDetail = Resource.success(DataDummy.generateDetailDummy(showsType))
        val tvShowsDetail = MutableLiveData<Resource<ShowsEntity>>()
        tvShowsDetail.value = dummyTvShowsDetail

        `when`(dummyTvShowsDetail.data?.let { showsRepository.getShowsDetail(it.id, showsType) }).thenReturn(tvShowsDetail)
        val showsDetailResult = dummyTvShowsDetail.data?.let { showsDetailViewModel.getShowsDetail(it.id, showsType).value }
        dummyTvShowsDetail.data?.let { verify(showsRepository).getShowsDetail(it.id, showsType) }
        assertNotNull(showsDetailResult)

        // live data test
        dummyTvShowsDetail.data?.let { showsDetailViewModel.getShowsDetail(it.id, showsType).observeForever(observer) }
        verify(observer).onChanged(dummyTvShowsDetail)
    }
}