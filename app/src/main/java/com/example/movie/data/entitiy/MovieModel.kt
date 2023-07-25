package com.example.movie.data.entitiy

import android.os.Parcelable
import com.example.movie.data.entitiy.*
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieModel(
    @SerializedName("title")
    val title:String?,
    @SerializedName("poster_path")
    val poster_path:String?,
    @SerializedName("release_date")
    val release_date:String?,
    @SerializedName("id")
    val id:Int?,
    @SerializedName("vote_average")
    val vote_average:Float?,
    @SerializedName("overview")
    val overview:String?,
    @SerializedName("genres")
    val genres:ArrayList<Genre>?,
    @SerializedName("runtime")
    val runtime:Int?,
    @SerializedName("backdrop_path")
    val backdrop_path:String?,
    @SerializedName("credits")
    val credits: Credits?,
    @SerializedName("reviews")
    val reviews: Reviews?,
    @SerializedName("recommendations")
    val recommendations: Recommendations?,
    @SerializedName("original_language")
    val original_language: String?,
    @SerializedName("external_ids")
    val external_ids: ExternalIds,
    @SerializedName("homepage")
    val homepage: String?,
    @SerializedName("revenue")
    val revenue: String?,
    @SerializedName("budget")
    val budget: String?,
    @SerializedName("status")
    val status: String?,
):Parcelable