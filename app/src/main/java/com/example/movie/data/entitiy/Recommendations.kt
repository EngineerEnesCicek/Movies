package com.example.movie.data.entitiy

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recommendations(
    @SerializedName("results")
    val results:ArrayList<MixModel>?
):Parcelable
