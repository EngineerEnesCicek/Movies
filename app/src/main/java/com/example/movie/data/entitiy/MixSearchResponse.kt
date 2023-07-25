package com.example.movie.data.entitiy

import android.os.Parcelable
import com.example.movie.data.entitiy.MixModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MixSearchResponse(
    @SerializedName("page")
    @Expose
    val page:Int?,
    @SerializedName("total_pages")
    @Expose
    val total_pages:Int?,
    @SerializedName("results")
    @Expose
    val model:ArrayList<MixModel>
):Parcelable
