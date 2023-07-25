package com.example.movie.data.entitiy

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Keywords(
    @SerializedName("results")
    val results: ArrayList<KeywordModel>?
):Parcelable
