package com.example.kotlinmoviecatalogue.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlinmoviecatalogue.ShowsFragment

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    private var isFavoriteFilter: Boolean = false

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = ShowsFragment.newInstance("movies", isFavoriteFilter)
            1 -> fragment = ShowsFragment.newInstance("tv_shows", isFavoriteFilter)
        }

        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 2
    }

    fun setShowsFilter(filter: Boolean) {
        this.isFavoriteFilter = filter
    }
}