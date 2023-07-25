package com.example.movie.core.functions

import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import com.example.movie.data.entitiy.MixModel
import com.example.movie.view.MainFragmentDirections
import com.example.movie.view.MovieListViewModel

fun itemClicked(mixModel: MixModel, movieListViewModel: MovieListViewModel, navController: NavController, owner: LifecycleOwner){
    when (mixModel.media_type) {
        "tv" -> {
            movieListViewModel.getTvShow(mixModel.id)
            movieListViewModel.mTvShow.observe(owner){
                navController.navigate(MainFragmentDirections.actionMainFragmentToTvShowDetailFragment(it))
            }
        }
        "movie" -> {
            movieListViewModel.getMovie(mixModel.id)
            movieListViewModel.mMovies.observe(owner){
                navController.navigate(MainFragmentDirections.actionMainFragmentToDetailFragment2(it))
            }
        }
        else -> {
            movieListViewModel.getPerson(mixModel.id)
            movieListViewModel.mPerson.observe(owner){
                navController.navigate(MainFragmentDirections.actionMainFragmentToActorDetailFragment(it))
            }
        }
    }
}