package com.example.movie.adapters

import com.example.movie.data.entitiy.TVShowModel

interface SelectTvShowListener {
    fun onTvShowClicked(tvShowModel: TVShowModel)
}