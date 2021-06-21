package com.example.kotlinmoviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.kotlinmoviecatalogue.data.source.local.LocalDataSource
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.data.source.remote.RemoteDataSource
import com.example.kotlinmoviecatalogue.util.*
import com.example.kotlinmoviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class ShowsRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val showsRepository = FakeShowsRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateDummy("movies")
    private val tvShowsResponses = DataDummy.generateDummy("tv_shows")

    private val movieId = movieResponses[0].id
    private val tvShowsId = tvShowsResponses[0].id

    private val movieDetail = DataDummy.generateDetailDummy("movies")
    private val tvShowsDetail = DataDummy.generateDetailDummy("tv_shows")

    @Test
    fun testGetMoviesData() = getShowsData("movies")

    @Test
    fun testGetMovieDetailData() = getShowsDetailData(movieId, "movies")

    @Test
    fun testGetMoviesFavoriteData() = getShowsFavoriteData("movies")

    @Test
    fun testGetTvShowsData() = getShowsData("tv_shows")

    @Test
    fun testGetTvShowDetailData() = getShowsDetailData(tvShowsId, "tv_shows")

    @Test
    fun testGetTvShowsFavoriteData() = getShowsFavoriteData("tv_shows")

    private fun getShowsData(showsType: String) {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ShowsEntity>
        `when`(local.getShows(showsType)).thenReturn(dataSourceFactory)
        showsRepository.getShows(showsType)

        val showsEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummy(showsType)))
        verify(local).getShows(showsType)
        assertNotNull(showsEntities.data)

        if (showsType == "movies") {
            assertEquals(movieResponses.size.toLong(), (showsEntities.data)?.size?.toLong())
        } else if (showsType == "tv_shows") {
            assertEquals(tvShowsResponses.size.toLong(), (showsEntities.data)?.size?.toLong())
        }
    }

    private fun getShowsDetailData(showsId: Int, showsType: String) {
        val dummyShowsDetail = MutableLiveData<ShowsEntity>()
        dummyShowsDetail.value = DataDummy.generateDetailDummy(showsType)
        `when`(local.getShowsDetail(showsId)).thenReturn(dummyShowsDetail)

        val showsDetailEntities = LiveTestDataUtil.getValue(showsRepository.getShowsDetail(showsId, showsType))
        verify(local).getShowsDetail(showsId)
        assertNotNull(showsDetailEntities.data)

        if (showsType == "movies") {
            assertEquals(movieDetail.title, showsDetailEntities.data?.title)
        } else if (showsType == "tv_shows") {
            assertEquals(tvShowsDetail.name, showsDetailEntities.data?.name)
        }
    }

    private fun getShowsFavoriteData(showsType: String) {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ShowsEntity>
        `when`(local.getShowsFavorite(showsType)).thenReturn(dataSourceFactory)
        showsRepository.getShowsFavorite(showsType)

        val showsEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummy(showsType)))
        verify(local).getShowsFavorite(showsType)
        assertNotNull(showsEntities.data)

        if (showsType == "movies") {
            assertEquals(movieResponses.size.toLong(), (showsEntities.data)?.size?.toLong())
        } else if (showsType == "tv_shows") {
            assertEquals(tvShowsResponses.size.toLong(), (showsEntities.data)?.size?.toLong())
        }
    }
}