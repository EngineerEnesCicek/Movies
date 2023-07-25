package com.example.movie.data.entitiy

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Reviewer(
    @SerializedName("author_details")
    val author_details: AuthorDetails?,
    @SerializedName("content")
    val content:String?
):Parcelable
