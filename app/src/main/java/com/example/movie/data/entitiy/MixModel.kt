package com.example.movie.data.entitiy

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MixModel(
    @SerializedName("title")
    val title:String?,
    @SerializedName("poster_path")
    val poster_path:String?,
    @SerializedName("release_date")
    val release_date:String?,
    @SerializedName("id")
    val id:Int,
    @SerializedName("vote_average")
    val vote_average:Float?,
    @SerializedName("media_type")
    val media_type:String?,
    @SerializedName("name")
    val name:String?,
    @SerializedName("profile_path")
    val profile_path:String?,
    @SerializedName("known_for_department")
    val known_for_department:String?,
    @SerializedName("backdrop_path")
    val backdrop_path:String?,
    @SerializedName("overview")
    val overview:String?,

):Parcelable