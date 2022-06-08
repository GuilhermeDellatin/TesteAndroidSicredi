package com.gfdellatin.testeandroidsicredi.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
    val id: String?,
    val people: List<People>,
    val date: Long,
    val description: String,
    val image: String,
    val longitude: String,
    val latitude: String,
    val price: Double,
    val title: String
) : Parcelable {

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun equals(other: Any?) = (other is Event) && id == other.id
}