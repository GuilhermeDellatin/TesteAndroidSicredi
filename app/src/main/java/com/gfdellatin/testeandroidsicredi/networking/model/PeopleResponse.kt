package com.gfdellatin.testeandroidsicredi.networking.model

import com.google.gson.annotations.SerializedName

data class PeopleResponse(
    val id: String,
    @SerializedName("eventId")
    val eventId: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
)