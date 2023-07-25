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
import com.example.movie.adapters.MixAdapter
import com.example.movie.adapters.SelectListener
import com.example.movie.databinding.FragmentTodayTrendsBinding
import com.example.movie.core.functions.itemClicked
import com.example.movie.data.entitiy.MixModel

class TodayTrendsFragment : Fragment(), SelectListener {
    private lateinit var navController: NavController
    private lateinit var movieListViewModel: MovieListViewModel
    private lateinit var recyclerView: RecyclerView
    lateinit var binding: FragmentTodayTrendsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodayTrendsBinding.inflate(layoutInflater, container, false)
        recyclerView = this.binding.todayTrendsRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        movieListViewModel = ViewModelProvider(this)[MovieListViewModel::class.java]
        movieListViewModel.getTrendToday()
        movieListViewModel.mModels.observe(viewLifecycleOwner) {
            val adapter = MixAdapter(it, this)
            recyclerView.adapter = adapter
        }
        return binding.root
    }
    override fun onItemClicked(mixModel: MixModel) {
        itemClicked(mixModel,movieListViewModel,navController,viewLifecycleOwner)
    }
}