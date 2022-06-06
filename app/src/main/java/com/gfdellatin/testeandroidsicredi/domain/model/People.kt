package com.gfdellatin.testeandroidsicredi.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class People(
    val eventId: String,
    val name: String,
    val email: String,
) : Parcelable