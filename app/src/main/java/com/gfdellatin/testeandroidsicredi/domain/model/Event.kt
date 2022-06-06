package com.gfdellatin.testeandroidsicredi.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
    val id: String,
    val people: List<People>,
    val date: String,
    val description: String,
    val image: String,
    val longitude: String,
    val latitude: String,
    val price: Double,
    val title: String
) : Parcelable