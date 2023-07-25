package com.example.movie.data.entitiy

import com.example.movie.data.entitiy.ActorModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PopularPersonResponse(
    @SerializedName("total_pages")
    @Expose
    val total_pages:Int?,
    @SerializedName("results")
    @Expose
    val results:ArrayList<ActorModel>?
)
