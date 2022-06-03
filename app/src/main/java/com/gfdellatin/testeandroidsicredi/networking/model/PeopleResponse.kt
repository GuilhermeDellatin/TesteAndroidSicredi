package com.gfdellatin.testeandroidsicredi.networking.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PeopleResponse(
    @SerializedName("eventId")
    val eventId: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
): Parcelable