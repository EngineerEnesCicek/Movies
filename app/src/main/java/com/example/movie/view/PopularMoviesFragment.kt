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
import com.example.movie.databinding.FragmentPopularMoviesBinding
import com.example.movie.adapters.SelectMovieListener
import com.example.movie.data.entitiy.MovieModel
import com.example.movie.adapters.PopularMoviesAdapter

class PopularMoviesFragment : Fragment(), SelectMovieListener {
    private lateinit var navController: NavController
    private lateinit var movieListViewModel: MovieListViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentPopularMoviesBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentPopularMoviesBinding.inflate(layoutInflater,container,false)
        recyclerView = this.binding.popularMoviesRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        movieListViewModel = ViewModelProvider(this)[MovieListViewModel::class.java]
        movieListViewModel.getPopularMovies(1)
        movieListViewModel.mPopularMovies.observe(viewLifecycleOwner) {
            val adapter = PopularMoviesAdapter(it, this)
            recyclerView.adapter = adapter
        }
        return binding.root
    }

    override fun onMovieClicked(movieModel: MovieModel) {
        movieModel.id?.let { movieListViewModel.getMovie(it) }
        movieListViewModel.mMovies.observe(viewLifecycleOwner){
            val action = MainFragmentDirections.actionMainFragmentToDetailFragment2(it)
            navController.navigate(action)
        }
    }


}