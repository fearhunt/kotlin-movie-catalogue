package com.example.kotlinmoviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.kotlinmoviecatalogue.databinding.ActivityShowsDetailBinding
import com.example.kotlinmoviecatalogue.util.ConvertCurrency
import com.example.kotlinmoviecatalogue.vm.ShowsDetailViewModel
import com.example.kotlinmoviecatalogue.vm.ViewModelFactory
import java.time.LocalDate
import java.util.*

class ShowsDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowsDetailBinding
    private lateinit var tags: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val showsId = intent.getIntExtra(EXTRA_SHOWS_ID, 0)
        val showsType = intent.getStringExtra(EXTRA_SHOWS_TYPE)
        val showsDetailViewModel = ViewModelProvider(this, ViewModelFactory.getInstance(this))[ShowsDetailViewModel::class.java]
        val progressOverlay = binding.includedProgress.progressOverlay

        progressOverlay.visibility = View.VISIBLE
        progressOverlay.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in))

        if (showsType != null) {
            tags = ""

            showsDetailViewModel.getShowsDetail(showsId, showsType).observe(this, { showsDetail ->
                progressOverlay.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_out))
                Handler().postDelayed({
                    progressOverlay.visibility = View.GONE
                }, 500)

                val showsScore = (showsDetail.voteAverage * 10).toInt()

                Glide.with(this)
                    .load(BASE_POSTER_URL + showsDetail.posterPath)
                    .transform(RoundedCorners(applicationContext.resources.getDimensionPixelSize(R.dimen.border_radius)))
                    .into(binding.imgPoster)

                with(binding) {
                    tvShowsTitle.text = showsDetail.title ?: showsDetail.name
                    tvShowsReleaseYear.text = LocalDate.parse(showsDetail.releaseDate ?: showsDetail.firstAirDate).year.toString()
                    tvShowsOverview.text = showsDetail.overview
                    tvShowsLanguage.text = Locale(showsDetail.originalLanguage).getDisplayLanguage()
                    tvShowsScore.text = getString(R.string.shows_score, showsScore.toString())
                    scoreBar.progress = showsScore

                    if (showsType == "movies") {
                        tvShowsBudget.text = ConvertCurrency().currencyWithCode(showsDetail.budget, "USD")
                        tvShowsRevenue.text = ConvertCurrency().currencyWithCode(showsDetail.revenue, "USD")
                    } else {
                        tvBudget.visibility = View.GONE
                        tvShowsBudget.visibility = View.GONE
                        tvRevenue.visibility = View.GONE
                        tvShowsRevenue.visibility = View.GONE
                    }

                    (showsDetail.genres).forEachIndexed { index, tag ->
                        tags += tag.name

                        if (index < ((showsDetail.genres).size - 1)) {
                            tags += ", "
                        }
                    }

                    tvShowsTags.text = tags
                }
            })
        }
    }

    companion object {
        const val EXTRA_SHOWS_ID = "extra_shows_id"
        const val EXTRA_SHOWS_TYPE = "extra_shows_type"
        const val BASE_POSTER_URL = "https://image.tmdb.org/t/p/w200/"
    }
}