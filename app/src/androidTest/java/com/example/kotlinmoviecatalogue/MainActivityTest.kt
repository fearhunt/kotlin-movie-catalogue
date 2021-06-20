package com.example.kotlinmoviecatalogue

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.kotlinmoviecatalogue.util.CurrencyConverter
import com.example.kotlinmoviecatalogue.util.DataDummy
import com.example.kotlinmoviecatalogue.util.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.time.LocalDate
import java.util.*

class MainActivityTest {
    private val dummyMovies = DataDummy.generateDummy("movies")
    private val dummyTvShows = DataDummy.generateDummy("tv_shows")

    private val dummyMovieDetail = DataDummy.generateDetailDummy("movies")
    private val dummyTvShowsDetail = DataDummy.generateDetailDummy("tv_shows")

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.results.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_shows_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_title)).check(matches(withText(dummyMovieDetail.title)))
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_release_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_release_year)).check(matches(withText(LocalDate.parse(dummyMovieDetail.releaseDate).year.toString())))
        onView(withId(R.id.tv_shows_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_overview)).check(matches(withText(dummyMovieDetail.overview)))
        onView(withId(R.id.tv_shows_tags)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_score)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_score)).check(matches(withText("${((dummyMovieDetail.voteAverage) * 10).toInt()}%")))
        onView(withId(R.id.tv_shows_language)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_language)).check(matches(withText(Locale(dummyMovieDetail.originalLanguage).getDisplayLanguage())))
        onView(withId(R.id.tv_shows_budget)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_budget)).check(matches(dummyMovieDetail.budget?.let { withText(CurrencyConverter().currencyWithCode(it, "USD")) }))
        onView(withId(R.id.tv_shows_revenue)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_revenue)).check(matches(dummyMovieDetail.revenue?.let { withText(CurrencyConverter().currencyWithCode(it, "USD")) }))
    }

    @Test
    fun loadTvShows() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShows.results.size
        ))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_shows_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_title)).check(matches(withText(dummyTvShowsDetail.name)))
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_release_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_release_year)).check(matches(withText(LocalDate.parse(dummyTvShowsDetail.firstAirDate).year.toString())))
        onView(withId(R.id.tv_shows_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_overview)).check(matches(withText(dummyTvShowsDetail.overview)))
        onView(withId(R.id.tv_shows_tags)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_score)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_score)).check(matches(withText("${((dummyTvShowsDetail.voteAverage) * 10).toInt()}%")))
        onView(withId(R.id.tv_shows_language)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_shows_language)).check(matches(withText(Locale(dummyTvShowsDetail.originalLanguage).getDisplayLanguage())))
    }
}