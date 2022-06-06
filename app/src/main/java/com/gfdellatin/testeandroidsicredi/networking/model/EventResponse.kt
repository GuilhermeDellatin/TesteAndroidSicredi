package com.gfdellatin.testeandroidsicredi.networking.model

import com.google.gson.annotations.SerializedName

data class EventResponse (
    @SerializedName("id")
    val id: String,
    @SerializedName("people")
    val people: List<PeopleResponse>,
    @SerializedName("date")
    val date: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("title")
    val title: String
)