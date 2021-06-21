package com.example.kotlinmoviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.kotlinmoviecatalogue.data.source.local.LocalDataSource
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.data.source.remote.RemoteDataSource
import com.example.kotlinmoviecatalogue.util.*
import com.example.kotlinmoviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

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
    fun testGetMoviesData() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ShowsEntity>
        `when`(local.getShows(QueryUtils.getShowsQuery("movies"))).thenReturn(dataSourceFactory)
        showsRepository.getShows("movies")

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummy("movies")))
        verify(local).getShows(QueryUtils.getShowsQuery("movies"))
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), (movieEntities.data)?.size?.toLong())

//        doAnswer { invocation ->
//            (invocation.arguments[1] as RemoteDataSource.LoadShowsCallback).onAllShowsReceived(movieEntities)
//            null
//        }.`when`(remote).getShows(eq("movies"), any())
//
//        val movieEntities = LiveTestDataUtil.getValue(showsRepository.getShows("movies"))
//        verify(remote).getShows(eq("movies"), any())
//        assertNotNull(movieEntities)
//        assertEquals(movieEntities.results.size.toLong(), movieEntities.results.size.toLong())
    }

//    @Test
//    fun testGetMovieDetailData() {
//        doAnswer { invocation ->
//            (invocation.arguments[2] as RemoteDataSource.LoadShowsDetailCallback).onDetailShowsReceived(movieDetail)
//            null
//        }.`when`(remote).getShowsDetail(eq(movieId), eq("movies"), any())
//
//        val movieDetailEntities = LiveTestDataUtil.getValue(showsRepository.getShowsDetail(movieId, "movies"))
//        verify(remote).getShowsDetail(eq(movieId), eq("movies"), any())
//        assertNotNull(movieDetailEntities)
//        assertEquals(movieDetail.title, movieDetailEntities.title)
//    }
//
//    @Test
//    fun testGetTvShowsData() {
//        doAnswer { invocation ->
//            (invocation.arguments[1] as RemoteDataSource.LoadShowsCallback).onAllShowsReceived(tvShowsEntities)
//            null
//        }.`when`(remote).getShows(eq("tv_shows"), any())
//
//        val tvShowsEntities = LiveTestDataUtil.getValue(showsRepository.getShows("tv_shows"))
//        verify(remote).getShows(eq("tv_shows"), any())
//        assertNotNull(tvShowsEntities)
//        assertEquals(tvShowsEntities.results.size.toLong(), tvShowsEntities.results.size.toLong())
//    }
//
//    @Test
//    fun testGetTvShowDetailData() {
//        doAnswer { invocation ->
//            (invocation.arguments[2] as RemoteDataSource.LoadShowsDetailCallback).onDetailShowsReceived(tvShowsDetail)
//            null
//        }.`when`(remote).getShowsDetail(eq(tvShowsId), eq("tv_shows"), any())
//
//        val tvShowsDetailEntities = LiveTestDataUtil.getValue(showsRepository.getShowsDetail(tvShowsId, "tv_shows"))
//        verify(remote).getShowsDetail(eq(tvShowsId), eq("tv_shows"), any())
//        assertNotNull(tvShowsDetailEntities)
//        assertEquals(tvShowsDetail.title, tvShowsDetailEntities.title)
//    }
}