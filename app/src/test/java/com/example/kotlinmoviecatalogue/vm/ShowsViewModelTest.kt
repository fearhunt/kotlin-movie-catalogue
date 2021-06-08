package com.example.kotlinmoviecatalogue.vm

import com.example.kotlinmoviecatalogue.entity.ShowsEntity
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
    fun testGetShowsData() {

    }
}