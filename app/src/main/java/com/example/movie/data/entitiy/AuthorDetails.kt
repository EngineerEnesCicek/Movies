package com.example.movie.data.entitiy

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class AuthorDetails(
    @SerializedName("name")
    val name:String?,
    @SerializedName("avatar_path")
    val avatar_path:String?,
    @SerializedName("rating")
    val rating:Float?,
):Parcelable
