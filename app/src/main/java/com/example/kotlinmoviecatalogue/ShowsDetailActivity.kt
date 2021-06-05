package com.example.kotlinmoviecatalogue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmoviecatalogue.databinding.ActivityShowsDetailBinding
import com.example.kotlinmoviecatalogue.util.Capitalize
import com.example.kotlinmoviecatalogue.vm.ShowsDetailViewModel
import java.text.NumberFormat
import java.util.*

class ShowsDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowsDetailBinding
    private val showsDetailViewModel : ShowsDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val showsTitle = intent.getStringExtra(EXTRA_SHOWS_TITLE)
        val showsType = intent.getStringExtra(EXTRA_SHOWS_TYPE)

        with(showsDetailViewModel) {
            if (showsType != null) {
                setShowsDetailData(showsTitle, showsType, this@ShowsDetailActivity)
            }

            getShowsDetailData().observe(this@ShowsDetailActivity, { shows ->
                if (shows != null) {
                    val img = resources.getIdentifier(shows.poster, "drawable", packageName)
                    var tags = ""

                    with(binding) {
                        imgPoster.setImageResource(img)
                        tvShowsTitle.text = shows.title
                        tvShowsReleaseYear.text = shows.release_year
                        tvShowsOverview.text = shows.overview
                        tvShowsLanguage.text = shows.language
                        tvShowsScore.text = "${shows.score}%"
                        scoreBar.progress = shows.score

                        if (showsType == "movies") {
                            val currencyInstance = NumberFormat.getCurrencyInstance()
                            currencyInstance.maximumFractionDigits = 0
                            currencyInstance.currency = Currency.getInstance("USD")

                            tvShowsBudget.text = currencyInstance.format(shows.budget)
                            tvShowsRevenue.text = currencyInstance.format(shows.revenue)
                        }
                        else {
                            tvBudget.visibility = View.GONE
                            tvShowsBudget.visibility = View.GONE
                            tvRevenue.visibility = View.GONE
                            tvShowsRevenue.visibility = View.GONE
                        }

                        (shows.tags).forEachIndexed { index, tag ->
                            tags += Capitalize().capitalizeEachWord(tag)

                            if (index < ((shows.tags).size - 1)) {
                                tags += ", "
                            }
                        }

                        tvShowsTags.text = tags
                    }
                }
            })
        }
    }

    companion object {
        const val EXTRA_SHOWS_TITLE = "extra_shows_title"
        const val EXTRA_SHOWS_TYPE = "extra_shows_type"
    }
}