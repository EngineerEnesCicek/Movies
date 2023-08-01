package com.example.movie.data.service

import com.example.movie.core.util.Constants
import com.example.movie.data.entitiy.ActorModel
import com.example.movie.data.entitiy.MixModel
import com.example.movie.data.entitiy.MovieModel
import com.example.movie.data.entitiy.TVShowModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository {
    fun getAllRetrofitResponse(
        apiKey: String,
        search: String,
        pageNumber: String,
        modelList: (ArrayList<MixModel>) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val movieApi: MovieAPI = Services.service
            val response = movieApi.getSearchAll(apiKey, search, pageNumber)
            if (response.isSuccessful) {
                modelList(response.body()!!.model)
            }
        }
    }

    fun getTrendTodayResponse(apiKey: String, movieList: (ArrayList<MixModel>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val movieApi: MovieAPI = Services.service
            val responseCall = movieApi.getTrend(apiKey)
            if (responseCall.isSuccessful) {
                movieList(responseCall.body()!!.model)
            }
        }
    }

    fun getTrendThisWeekResponse(apiKey: String, movieList: (ArrayList<MixModel>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val movieAPI: MovieAPI = Services.service
            val response = movieAPI.getTrendThisWeek(apiKey)
            if (response.isSuccessful) {
                movieList(response.body()!!.model)
            }
        }
    }

    fun getRetrofitPersonIdResponse(
        personId: Int,
        apiKey: String,
        personModel: (ActorModel?) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val movieApi: MovieAPI = Services.service
            val response = movieApi.getPerson(personId, apiKey, Constants.APPENDACTOR)
            if (response.isSuccessful) {
                personModel(response.body())
            }
        }
    }

    fun getRetrofitTvShowIdResponse(
        tvShowId: Int,
        apiKey: String,
        tvShowModel: (TVShowModel?) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val movieApi: MovieAPI = Services.service
            val response = movieApi.getTvShow(tvShowId, apiKey, Constants.APPENDTVSHOW)
            if (response.isSuccessful) {
                tvShowModel(response.body())
            }
        }
    }

    fun getRetrofitMovieIdResponse(
        movieId: Int,
        apiKey: String,
        movieModel: (MovieModel?) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val movieApi: MovieAPI = Services.service
            val response = movieApi.getMovie(movieId, apiKey, Constants.APPENDMOVIE)
            if (response.isSuccessful) {
                movieModel(response.body())
            }
        }
    }

    fun getPopularMovies(
        apiKey: String,
        pageNumber: Int,
        movieModelList: (ArrayList<MovieModel>?) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val movieApi: MovieAPI = Services.service
            val response = movieApi.getPopularMovies(apiKey, pageNumber)
            if (response.isSuccessful) {
                response.body()?.let { movieModelList(it.results) }
            }
        }
    }

    fun getPopularTvShow(
        apiKey: String,
        pageNumber: Int,
        tvShowModelList: (ArrayList<TVShowModel>?) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val movieApi: MovieAPI = Services.service
            val response = movieApi.getPopularTvShow(apiKey, pageNumber)
            if (response.isSuccessful) {
                response.body()?.let { tvShowModelList(it.results) }
            }
        }
    }

    fun getPopularActors(
        apiKey: String,
        pageNumber: Int,
        actorModelList: (ArrayList<ActorModel>?) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val movieApi: MovieAPI = Services.service
            val response = movieApi.getPopularPerson(apiKey, pageNumber)
            if (response.isSuccessful) {
                response.body()?.let { actorModelList(it.results) }
            }
        }
    }

}