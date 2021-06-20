package com.example.kotlinmoviecatalogue

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmoviecatalogue.adapter.ListShowsAdapter
import com.example.kotlinmoviecatalogue.databinding.FragmentShowsBinding
import com.example.kotlinmoviecatalogue.vm.ShowsViewModel
import com.example.kotlinmoviecatalogue.vm.ViewModelFactory
import com.example.kotlinmoviecatalogue.vo.Status

class ShowsFragment : Fragment() {
    private lateinit var showsAdapter: ListShowsAdapter
    private var _binding: FragmentShowsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val showsType = arguments?.getString("showsType")
        val showsViewModel = ViewModelProvider(this, ViewModelFactory.getInstance(requireActivity()))[ShowsViewModel::class.java]

        showsAdapter = ListShowsAdapter(showsType)

        if (showsType != null) {
            showsViewModel.getShows(showsType).observe(viewLifecycleOwner) { shows ->
                if (shows != null) {
                    when (shows.status) {
                        Status.LOADING -> binding.progressLoad.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding.progressLoad.visibility = View.GONE

                            showsAdapter.setData(shows.data)

                            with(binding.rvShows) {
                                layoutManager = LinearLayoutManager(activity)
                                adapter = showsAdapter
                            }
                        }
                        Status.ERROR -> {
                            binding.progressLoad.visibility = View.GONE

                            Toast.makeText(activity, "Something's wrong", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentShowsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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