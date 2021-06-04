package com.example.kotlinmoviecatalogue

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmoviecatalogue.adapter.ListShowsAdapter
import com.example.kotlinmoviecatalogue.databinding.FragmentShowsBinding
import com.example.kotlinmoviecatalogue.vm.ShowsViewModel

class ShowsFragment : Fragment() {
    private lateinit var showsAdapter: ListShowsAdapter
    private lateinit var binding: FragmentShowsBinding
    private val showsViewModel : ShowsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentShowsBinding.inflate(layoutInflater)

        val showsType = arguments?.getString("showsType")

        showsAdapter = ListShowsAdapter()

        with(binding.rvShows) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = showsAdapter
        }

        showsAdapter.clearData()

        showsType?.let { showsViewModel.setShowsData(it, activity) }
        showsViewModel.getShowsData().observe(viewLifecycleOwner) { shows ->
            if (shows.isNotEmpty()) {
                showsAdapter.setData(shows)
            }
//            else {
//                Log.i("emptyShows", "set shows data")
//                showsType?.let { showsViewModel.setShowsData(it, activity) }
//            }
        }

//        with(showsViewModel) {
//            if (showsType != null) {
//                setShowsData(showsType, activity)
//            }
//
//            getShowsData().observe(viewLifecycleOwner) { shows ->
//                if (shows.isNotEmpty()) {
//                    showsAdapter.setData(shows)
//                }
//                else {
//                    Log.i("emptyShows", "set shows data")
//                    if (showsType != null) {
//                        setShowsData(showsType, activity)
//                    }
//                }
//            }
//        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(showsType: String?) = ShowsFragment().apply {
            val fragment = ShowsFragment()
            val bundle = Bundle()

            bundle.putString("showsType", showsType)
            fragment.arguments = bundle

            return fragment
        }
    }
}