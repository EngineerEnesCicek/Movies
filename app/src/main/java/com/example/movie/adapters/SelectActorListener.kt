package com.example.movie.adapters

import com.example.movie.data.entitiy.ActorModel

interface SelectActorListener {
    fun onActorClicked(actorModel: ActorModel)
}