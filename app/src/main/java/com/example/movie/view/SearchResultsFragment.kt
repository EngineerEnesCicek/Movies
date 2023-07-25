package com.example.movie.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.adapters.SelectListener
import com.example.movie.databinding.FragmentSearchResultsBinding
import com.example.movie.core.functions.itemClicked
import com.example.movie.adapters.SearchAdapter
import com.example.movie.data.entitiy.MixModel

class SearchResultsFragment : Fragment(), SelectListener {
    private lateinit var navController: NavController
    private var searchText: String = ""
    private lateinit var binding: FragmentSearchResultsBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieListViewModel: MovieListViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchResultsBinding.inflate(layoutInflater, container, false)
        recyclerView = binding.searchRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        movieListViewModel = ViewModelProvider(this)[MovieListViewModel::class.java]
        binding.button.setOnClickListener {
            searchText = binding.searchMovieText.text.toString()
            show(searchText)
        }
        return binding.root
    }

    private fun show(name: String) {
        movieListViewModel.searchAll(name, "1")
        movieListViewModel.mModels.observe(viewLifecycleOwner) {
            val adapter = SearchAdapter(it, this)
            recyclerView.adapter = adapter
        }
    }

    override fun onItemClicked(mixModel: MixModel) {
        itemClicked(mixModel,movieListViewModel,navController,viewLifecycleOwner)
    }
}