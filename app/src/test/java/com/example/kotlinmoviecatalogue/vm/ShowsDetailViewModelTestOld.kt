//package com.example.kotlinmoviecatalogue.vm
//
//import com.example.kotlinmoviecatalogue.util.DataDummy
//import junit.framework.TestCase
//import org.junit.Before
//import org.junit.Test
//
//class ShowsDetailViewModelTestOld : TestCase() {
//    private lateinit var showsDetailViewModel: ShowsDetailViewModel
//    private val dummyMovie = DataDummy.generateDummy("movies")[0]
//    private val dummyTvShow = DataDummy.generateDummy("tv_shows")[0]
//    private val movieTitle = dummyMovie.title
//    private val tvShowTitle = dummyTvShow.title
//
//    @Before
//    override fun setUp() {
//        showsDetailViewModel = ShowsDetailViewModel()
//    }
//
//    @Test
//    fun testGetMovieDetailData() {
//        val movieDetail = showsDetailViewModel.getShowsDetailData(movieTitle, "movies")
//        assertNotNull(movieDetail)
//        assertEquals(dummyMovie.title, movieDetail.title)
//        assertEquals(dummyMovie.poster, movieDetail.poster)
//        assertEquals(dummyMovie.release_year, movieDetail.release_year)
//        assertEquals(dummyMovie.overview, movieDetail.overview)
//        assertEquals(dummyMovie.score, movieDetail.score)
//        assertEquals(dummyMovie.tags, movieDetail.tags)
//        assertEquals(dummyMovie.language, movieDetail.language)
//        assertEquals(dummyMovie.budget, movieDetail.budget)
//        assertEquals(dummyMovie.revenue, movieDetail.revenue)
//    }
//
//    @Test
//    fun testGetTvShowDetailData() {
//        val tvShowDetail = showsDetailViewModel.getShowsDetailData(tvShowTitle, "tv_shows")
//        assertNotNull(tvShowDetail)
//        assertEquals(dummyTvShow.title, tvShowDetail.title)
//        assertEquals(dummyTvShow.poster, tvShowDetail.poster)
//        assertEquals(dummyTvShow.release_year, tvShowDetail.release_year)
//        assertEquals(dummyTvShow.overview, tvShowDetail.overview)
//        assertEquals(dummyTvShow.score, tvShowDetail.score)
//        assertEquals(dummyTvShow.tags, tvShowDetail.tags)
//        assertEquals(dummyTvShow.language, tvShowDetail.language)
//        assertEquals(dummyTvShow.budget, tvShowDetail.budget)
//        assertEquals(dummyTvShow.revenue, tvShowDetail.revenue)
//    }
//}