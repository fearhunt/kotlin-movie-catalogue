package com.example.kotlinmoviecatalogue

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.kotlinmoviecatalogue.databinding.ActivityShowsDetailBinding
import com.example.kotlinmoviecatalogue.util.CurrencyConverter
import com.example.kotlinmoviecatalogue.vm.ShowsDetailViewModel
import com.example.kotlinmoviecatalogue.vm.ViewModelFactory
import com.example.kotlinmoviecatalogue.vo.Status
import java.time.LocalDate
import java.util.*

class ShowsDetailActivity : AppCompatActivity() {
    private lateinit var showsDetailViewModel: ShowsDetailViewModel
    private lateinit var binding: ActivityShowsDetailBinding
    private val isSuccessFetch = MutableLiveData<Boolean>()
    private var isFavorite: Boolean = false
    private var menu: Menu? = null

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actionBar?.setDisplayHomeAsUpEnabled(true)

        val showsId = intent.getIntExtra(EXTRA_SHOWS_ID, 0)
        val showsType = intent.getStringExtra(EXTRA_SHOWS_TYPE)
        showsDetailViewModel = ViewModelProvider(this, ViewModelFactory.getInstance(this))[ShowsDetailViewModel::class.java]

        val progressOverlay = binding.includedProgress.progressOverlay

        if (showsType != null) {
            showsDetailViewModel.getShowsDetail(showsId, showsType).observe(this) { showsDetail ->
                if (showsDetail != null) {
                    when (showsDetail.status) {
                        Status.LOADING -> {
                            progressOverlay.visibility = View.VISIBLE
                            progressOverlay.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in))

                            isSuccessFetch.value = false
                        }
                        Status.SUCCESS -> {
                            progressOverlay.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_out))
                            Handler().postDelayed({
                                progressOverlay.visibility = View.GONE
                            }, 500)

                            if (showsDetail.data != null) {
                                isSuccessFetch.value = true

                                showsDetail.data.isFavorite?.let { isFavorite = it }

                                val voteAverage = showsDetail.data.voteAverage ?: 0.0
                                val showsScore = (voteAverage * 10).toInt()

                                Glide.with(this)
                                    .load(BASE_POSTER_URL + showsDetail.data.posterPath)
                                    .transform(RoundedCorners(applicationContext.resources.getDimensionPixelSize(R.dimen.border_radius)))
                                    .into(binding.imgPoster)

                                with(binding) {
                                    tvShowsTitle.text = showsDetail.data.title ?: showsDetail.data.name
                                    tvShowsReleaseYear.text = LocalDate.parse(showsDetail.data.releaseDate ?: showsDetail.data.firstAirDate).year.toString()
                                    tvShowsOverview.text = showsDetail.data.overview
                                    tvShowsLanguage.text = Locale(showsDetail.data.originalLanguage).getDisplayLanguage()
                                    tvShowsTags.text = showsDetail.data.genres
                                    tvShowsScore.text = getString(R.string.shows_score, showsScore.toString())
                                    scoreBar.progress = showsScore

                                    if (showsType == "movies") {
                                        tvShowsBudget.text = CurrencyConverter().currencyWithCode(showsDetail.data.budget, "USD")
                                        tvShowsRevenue.text = CurrencyConverter().currencyWithCode(showsDetail.data.revenue, "USD")
                                    } else {
                                        tvBudget.visibility = View.GONE
                                        tvShowsBudget.visibility = View.GONE
                                        tvRevenue.visibility = View.GONE
                                        tvShowsRevenue.visibility = View.GONE
                                    }
                                }
                            }
                        }
                        Status.ERROR -> {
                            progressOverlay.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_out))
                            Handler().postDelayed({
                                progressOverlay.visibility = View.GONE
                            }, 500)

                            isSuccessFetch.value = false

                            Toast.makeText(this, "Something's wrong", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu

        isSuccessFetch.observe(this) {
            if (it) {
                menu.findItem(R.id.action_favorite).isEnabled = true
                setFavoriteState(isFavorite)
            }
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            showsDetailViewModel.setFavorite()
            isFavorite = !isFavorite
            setFavoriteState(isFavorite)

            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return

        val menuItem = menu?.findItem(R.id.action_favorite)

        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_star_filled)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_star_outlined)
        }
    }

    companion object {
        const val EXTRA_SHOWS_ID = "extra_shows_id"
        const val EXTRA_SHOWS_TYPE = "extra_shows_type"
        const val BASE_POSTER_URL = "https://image.tmdb.org/t/p/w200/"
    }
}