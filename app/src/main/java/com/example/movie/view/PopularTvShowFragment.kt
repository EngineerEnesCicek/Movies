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
import com.example.movie.databinding.FragmentPopularTvShowBinding
import com.example.movie.data.entitiy.TVShowModel
import com.example.movie.adapters.PopularTvShowAdapter
import com.example.movie.adapters.SelectTvShowListener

class PopularTvShowFragment : Fragment(), SelectTvShowListener {
    private lateinit var navController: NavController
    private lateinit var movieListViewModel: MovieListViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding:FragmentPopularTvShowBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding= FragmentPopularTvShowBinding.inflate(layoutInflater,container,false)
        recyclerView = this.binding.popularTvShowRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        movieListViewModel = ViewModelProvider(this)[MovieListViewModel::class.java]
        movieListViewModel.getPopularTvShow(1)
        movieListViewModel.mPopularTvShows.observe(viewLifecycleOwner) {
            val adapter = PopularTvShowAdapter(it, this)
            recyclerView.adapter = adapter
        }
        return binding.root
    }

    override fun onTvShowClicked(tvShowModel: TVShowModel) {
        tvShowModel.id?.let { movieListViewModel.getTvShow(it) }
        movieListViewModel.mTvShow.observe(viewLifecycleOwner){
            val action = MainFragmentDirections.actionMainFragmentToTvShowDetailFragment(it)
            navController.navigate(action)
        }
    }

}