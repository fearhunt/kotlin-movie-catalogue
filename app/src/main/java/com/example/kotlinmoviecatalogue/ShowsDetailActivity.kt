package com.example.kotlinmoviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.kotlinmoviecatalogue.databinding.ActivityShowsDetailBinding
import com.example.kotlinmoviecatalogue.util.Capitalize
import com.example.kotlinmoviecatalogue.util.ConvertCurrency
import com.example.kotlinmoviecatalogue.vm.ShowsDetailViewModel

class ShowsDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowsDetailBinding
    private val showsDetailViewModel : ShowsDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val showsTitle = intent.getStringExtra(EXTRA_SHOWS_TITLE)
        val showsType = intent.getStringExtra(EXTRA_SHOWS_TYPE)

        if (showsType != null) {
            val shows = showsDetailViewModel.getShowsDetailData(showsTitle, showsType)
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
                    tvShowsBudget.text = ConvertCurrency().currencyWithCode(shows.budget, "USD")
                    tvShowsRevenue.text = ConvertCurrency().currencyWithCode(shows.revenue, "USD")
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
    }

    companion object {
        const val EXTRA_SHOWS_TITLE = "extra_shows_title"
        const val EXTRA_SHOWS_TYPE = "extra_shows_type"
    }
}