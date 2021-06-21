package com.example.kotlinmoviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.StringRes
import com.example.kotlinmoviecatalogue.adapter.SectionsPagerAdapter
import com.example.kotlinmoviecatalogue.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        renderSectionsPagerAdapter()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_filter, menu)
        menu?.findItem(R.id.action_filter_popular)?.isChecked = true

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_filter_popular -> renderSectionsPagerAdapter(false)
            R.id.action_filter_favorite -> renderSectionsPagerAdapter(true)
        }

        item.isChecked = true

        return super.onOptionsItemSelected(item)
    }

    private fun renderSectionsPagerAdapter(isFavoriteFilter: Boolean = false) {
        supportActionBar?.subtitle = if (isFavoriteFilter) getString(R.string.current_filter, "Favorite ✨") else getString(R.string.current_filter, "Popular \uD83D\uDC53")

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        sectionsPagerAdapter.setShowsFilter(isFavoriteFilter)
        binding.viewPager.adapter = sectionsPagerAdapter

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
        supportActionBar?.elevation = 0f
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }
}