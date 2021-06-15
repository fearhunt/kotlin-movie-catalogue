package com.example.kotlinmoviecatalogue.vm

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class ShowsViewModelTest : TestCase() {
    private lateinit var showsViewModel: ShowsViewModel

    @Before
    override fun setUp() {
        showsViewModel = ShowsViewModel()
    }

    @Test
    fun testGetMoviesData() {
        val movies = showsViewModel.getShowsData("movies")
        assertNotNull(movies)
        assertEquals(10, movies.size)
    }

    @Test
    fun testGetTvShowsData() {
        val tvShows = showsViewModel.getShowsData("tv_shows")
        assertNotNull(tvShows)
        assertEquals(10, tvShows.size)
    }
}