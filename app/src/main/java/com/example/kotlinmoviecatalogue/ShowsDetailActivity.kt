package com.example.kotlinmoviecatalogue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmoviecatalogue.databinding.ActivityShowsDetailBinding
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

        with(showsDetailViewModel) {
            if (showsType != null) {
                setShowsDetailData(showsTitle, showsType, this@ShowsDetailActivity)
            }

            getShowsDetailData().observe(this@ShowsDetailActivity, { shows ->
                if (shows != null) {
                    val img = resources.getIdentifier(shows.poster, "drawable", packageName)

                    with(binding) {
                        imgPoster.setImageResource(img)
                        tvShowsTitle.text = shows.title
                        tvShowsReleaseYear.text = shows.release_year
                        tvShowsOverview.text = shows.overview
                        tvShowsScore.text = "${shows.score}%"
                        scoreBar.progress = shows.score
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