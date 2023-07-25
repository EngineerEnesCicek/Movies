package com.example.movie.data.entitiy

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class ActorModel (
    @SerializedName("name")
    val name:String?,
    @SerializedName("biography")
    val biography:String?,
    @SerializedName("gender")
    val gender:Int?,
    @SerializedName("place_of_birth")
    val place_of_birth:String?,
    @SerializedName("profile_path")
    val profile_path:String?,
    @SerializedName("id")
    val id:Int?,
    @SerializedName("character")
    val character:String?,
    @SerializedName("birthday")
    val birthday:String?,
    @SerializedName("known_for_department")
    val known_for_department:String?,
    @SerializedName("combined_credits")
    val combined_credits: CombinedCredits?,
    @SerializedName("external_ids")
    val external_ids: ExternalIds?,
):Parcelable