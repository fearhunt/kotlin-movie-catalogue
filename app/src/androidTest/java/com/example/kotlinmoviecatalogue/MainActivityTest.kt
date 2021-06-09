package com.example.kotlinmoviecatalogue

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.kotlinmoviecatalogue.util.ConvertCurrency
import com.example.kotlinmoviecatalogue.util.DataDummy
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private val dummyMovies = DataDummy.generateDummy("movies")
    private val dummyTvShows = DataDummy.generateDummy("tv_shows")

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_shows_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_title)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_release_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_release_year)).check(matches(withText(dummyMovies[0].release_year)))
        onView(withId(R.id.tv_shows_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_overview)).check(matches(withText(dummyMovies[0].overview)))
        onView(withId(R.id.tv_shows_tags)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_score)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_score)).check(matches(withText("${dummyMovies[0].score}%")))
        onView(withId(R.id.tv_shows_language)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_language)).check(matches(withText(dummyMovies[0].language)))
        onView(withId(R.id.tv_shows_budget)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_budget)).check(matches(dummyMovies[0].budget?.let { withText(ConvertCurrency().currencyWithCode(it, "USD")) }))
        onView(withId(R.id.tv_shows_revenue)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_revenue)).check(matches(dummyMovies[0].revenue?.let { withText(ConvertCurrency().currencyWithCode(it, "USD")) }))
    }

    @Test
    fun loadTvShows() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShows.size))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_shows_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_title)).check(matches(withText(dummyTvShows[0].title)))
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_release_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_release_year)).check(matches(withText(dummyTvShows[0].release_year)))
        onView(withId(R.id.tv_shows_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_overview)).check(matches(withText(dummyTvShows[0].overview)))
        onView(withId(R.id.tv_shows_tags)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_score)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_score)).check(matches(withText("${dummyTvShows[0].score}%")))
        onView(withId(R.id.tv_shows_language)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_language)).check(matches(withText(dummyTvShows[0].language)))
    }
}