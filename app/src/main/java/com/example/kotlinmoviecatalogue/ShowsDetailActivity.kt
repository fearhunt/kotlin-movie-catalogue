package com.example.kotlinmoviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinmoviecatalogue.databinding.ActivityShowsDetailBinding

class ShowsDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}