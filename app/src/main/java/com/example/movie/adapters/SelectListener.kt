package com.example.movie.adapters

import com.example.movie.data.entitiy.MixModel

interface SelectListener {
    fun onItemClicked(mixModel: MixModel)
}