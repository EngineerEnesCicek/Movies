package com.example.movie.adapters

import com.example.movie.data.entitiy.MovieModel

interface SelectMovieListener {
    fun onMovieClicked(movieModel: MovieModel)
}