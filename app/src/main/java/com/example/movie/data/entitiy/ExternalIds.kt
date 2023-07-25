package com.example.movie.data.entitiy

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExternalIds(
    @SerializedName("facebook_id")
    val facebook_id:String?,
    @SerializedName("instagram_id")
    val instagram_id:String?,
    @SerializedName("twitter_id")
    val twitter_id:String?
):Parcelable
