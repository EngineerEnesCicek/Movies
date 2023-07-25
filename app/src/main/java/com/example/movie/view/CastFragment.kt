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
import com.example.movie.adapters.ActorAdapter
import com.example.movie.data.entitiy.ActorModel
import com.example.movie.adapters.SelectActorListener
import com.example.movie.databinding.FragmentCastBinding


class CastFragment : Fragment(), SelectActorListener {
    private lateinit var binding: FragmentCastBinding
    private lateinit var navController: NavController
    private lateinit var movieListViewModel: MovieListViewModel
    private lateinit var recyclerView: RecyclerView
    var name = ""
    var title = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCastBinding.inflate(layoutInflater, container, false)
        recyclerView = this.binding.castRecyclerView
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        movieListViewModel = ViewModelProvider(this)[MovieListViewModel::class.java]

        val id = arguments?.getInt("id")
        name = arguments?.getString("name").toString()
        title = arguments?.getString("title").toString()
        if (name != "emptyName" && id != null) {
            movieListViewModel.getTvShow(id)
            movieListViewModel.mTvShow.observe(this) { tvShowModel ->
                val adapter = tvShowModel.credits?.cast?.let { it -> ActorAdapter(it, this) }
                recyclerView.adapter = adapter
            }
        }
        if (id != null && title != "emptyTitle") {
            movieListViewModel.getMovie(id)
        }
        movieListViewModel.mMovies.observe(viewLifecycleOwner) { movieModel ->
            val adapter = movieModel.credits?.cast?.let { it -> ActorAdapter(it, this) }
            recyclerView.adapter = adapter
        }
        return binding.root
    }

    override fun onActorClicked(actorModel: ActorModel) {
        actorModel.id?.let { movieListViewModel.getPerson(it) }
        movieListViewModel.mPerson.observe(this){
            if (title != "emptyTitle") {
                val action = MovieDetailFragmentDirections.actionDetailFragmentToActorDetailFragment(it)
                navController.navigate(action)
            }
            if (name != "emptyName") {
                val action=TvShowDetailFragmentDirections.actionTvShowDetailFragmentToActorDetailFragment(it)
                navController.navigate(action)

            }
        }

    }
}