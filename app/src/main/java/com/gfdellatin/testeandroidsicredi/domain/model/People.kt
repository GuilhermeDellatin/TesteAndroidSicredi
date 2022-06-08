package com.gfdellatin.testeandroidsicredi.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class People(
    val id: String?,
    val eventId: String?,
    val name: String,
    val email: String,
) : Parcelable