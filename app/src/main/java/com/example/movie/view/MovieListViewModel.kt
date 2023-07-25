package com.example.movie.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.movie.data.entitiy.MixModel
import com.example.movie.data.entitiy.MovieModel
import com.example.movie.data.entitiy.ActorModel
import com.example.movie.data.service.Repository
import com.example.movie.data.entitiy.TVShowModel
import com.example.movie.core.util.Constants

class MovieListViewModel(application: Application) : AndroidViewModel(application) {
    var mMovies = MutableLiveData<MovieModel>()
    var mTvShow = MutableLiveData<TVShowModel>()
    var mPerson = MutableLiveData<ActorModel>()
    var mModels = MutableLiveData<ArrayList<MixModel>>()
    var mPopularMovies=MutableLiveData<ArrayList<MovieModel>>()
    var mPopularTvShows=MutableLiveData<ArrayList<TVShowModel>>()
    var mPopularActors= MutableLiveData<ArrayList<ActorModel>>()
    private val allRepository = Repository()
    fun getPopularActors(pageNumber:Int){
        allRepository.getPopularActors(Constants.API_KEY,pageNumber){
            mPopularActors.postValue(it)
        }
    }
    fun getPopularTvShow(pageNumber:Int){
        allRepository.getPopularTvShow(Constants.API_KEY,pageNumber){
            mPopularTvShows.postValue(it)
        }
    }
    fun getPopularMovies(pageNumber:Int){
        allRepository.getPopularMovies(Constants.API_KEY,pageNumber){
            mPopularMovies.postValue(it)
        }
    }
    fun getMovie(movieId: Int) {
        allRepository.getRetrofitMovieIdResponse(movieId, Constants.API_KEY) {
            mMovies.postValue(it)
        }
    }

    fun getTvShow(tvShowId: Int) {
        allRepository.getRetrofitTvShowIdResponse(tvShowId, Constants.API_KEY) {
            mTvShow.postValue(it)
        }
    }

    fun getPerson(personId: Int) {
        allRepository.getRetrofitPersonIdResponse(personId, Constants.API_KEY) {
            mPerson.postValue(it)
        }
    }

    fun searchAll(searchMovie: String, pageNumber: String) {
        allRepository.getAllRetrofitResponse(Constants.API_KEY, searchMovie, pageNumber) {
            mModels.postValue(it)
        }
    }

    fun getTrendToday() {
        allRepository.getTrendTodayResponse(Constants.API_KEY) {
            mModels.postValue(it)
        }
    }

    fun getTrendThisWeek() {
        allRepository.getTrendThisWeekResponse(Constants.API_KEY) {
            mModels.postValue(it)
        }
    }
}