package com.example.movie.data.entitiy

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TVShowModel(
    @SerializedName("name")
    val name:String?,
    @SerializedName("poster_path")
    val poster_path:String?,
    @SerializedName("id")
    val id:Int?,
    @SerializedName("vote_average")
    val vote_average:Float?,
    @SerializedName("overview")
    val overview:String?,
    @SerializedName("media_type")
    val media_type:String?,
    @SerializedName("backdrop_path")
    val backdrop_path:String?,
    @SerializedName("first_air_date")
    val first_air_date:String?,
    @SerializedName("number_of_seasons")
    val number_of_seasons:Int?,
    @SerializedName("number_of_episodes")
    val number_of_episodes:Int?,
    @SerializedName("genres")
    val genres:ArrayList<Genre>?,
    @SerializedName("external_ids")
    val external_ids: ExternalIds?,
    @SerializedName("homepage")
    val homepage: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("credits")
    val credits: Credits?,
    @SerializedName("reviews")
    val reviews: Reviews?,
    @SerializedName("recommendations")
    val recommendations: Recommendations?,
    @SerializedName("original_language")
    val original_language: String?,
    @SerializedName("keywords")
    val keywords: Keywords?,
):Parcelable
