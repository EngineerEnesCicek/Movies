package com.example.movie.data.entitiy


import android.os.Parcelable
import com.example.movie.data.entitiy.ActorModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Credits(
    @SerializedName("cast")
    val cast: ArrayList<ActorModel>?
):Parcelable