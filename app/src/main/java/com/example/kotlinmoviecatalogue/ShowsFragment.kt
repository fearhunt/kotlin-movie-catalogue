package com.example.kotlinmoviecatalogue

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmoviecatalogue.adapter.ListShowsAdapter
import com.example.kotlinmoviecatalogue.databinding.FragmentShowsBinding
import com.example.kotlinmoviecatalogue.vm.ShowsViewModel

class ShowsFragment : Fragment() {
    private lateinit var showsAdapter: ListShowsAdapter
    private lateinit var binding: FragmentShowsBinding
    private val showsViewModel : ShowsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val showsType = arguments?.getString("showsType")

        showsAdapter = ListShowsAdapter(showsType)

        if (showsType != null) {
            val shows = showsViewModel.getShowsData(showsType)

            showsAdapter.setData(shows)

            with(binding.rvShows) {
                layoutManager = LinearLayoutManager(activity)
                adapter = showsAdapter
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentShowsBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(showsType: String?) = ShowsFragment().apply {
            arguments = Bundle().apply {
                putString("showsType", showsType)
            }
        }
    }
}