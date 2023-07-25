package com.example.movie.data.entitiy

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CombinedCredits(
    @SerializedName("cast")
    val cast: ArrayList<MixModel>?,
    @SerializedName("crew")
    val crew: ArrayList<MixModel>?
):Parcelable
