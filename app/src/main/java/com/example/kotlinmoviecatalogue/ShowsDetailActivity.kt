package com.example.kotlinmoviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.kotlinmoviecatalogue.databinding.ActivityShowsDetailBinding
import com.example.kotlinmoviecatalogue.util.ConvertCurrency
import com.example.kotlinmoviecatalogue.vm.ShowsDetailViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ShowsDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowsDetailBinding
    private lateinit var tags: String
    private val showsDetailViewModel : ShowsDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val showsId = intent.getIntExtra(EXTRA_SHOWS_ID, 0)
        val showsType = intent.getStringExtra(EXTRA_SHOWS_TYPE)

        if (showsType != null) {
            tags = ""

            showsDetailViewModel.getShowsDetail(showsId, showsType)
            showsDetailViewModel.showsDetail.observe(this, { showDetail ->
                val showsScore = (showDetail.voteAverage * 10).toInt()

                Glide.with(this)
                    .load("https://image.tmdb.org/t/p/w200/${showDetail.posterPath}")
                    .into(binding.imgPoster)

                with(binding) {
                    tvShowsTitle.text = showDetail.title ?: showDetail.name
                    tvShowsReleaseYear.text = LocalDate.parse(showDetail.releaseDate ?: showDetail.firstAirDate).year.toString()
                    tvShowsOverview.text = showDetail.overview
                    tvShowsLanguage.text = showDetail.spokenLanguages[0].englishName
                    tvShowsScore.text = getString(R.string.shows_score, showsScore.toString())
                    scoreBar.progress = showsScore

                    if (showsType == "movies") {
                        tvShowsBudget.text = ConvertCurrency().currencyWithCode(showDetail.budget, "USD")
                        tvShowsRevenue.text = ConvertCurrency().currencyWithCode(showDetail.revenue, "USD")
                    } else {
                        tvBudget.visibility = View.GONE
                        tvShowsBudget.visibility = View.GONE
                        tvRevenue.visibility = View.GONE
                        tvShowsRevenue.visibility = View.GONE
                    }

                    (showDetail.genres).forEachIndexed { index, tag ->
                        tags += tag.name

                        if (index < ((showDetail.genres).size - 1)) {
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
    }
}