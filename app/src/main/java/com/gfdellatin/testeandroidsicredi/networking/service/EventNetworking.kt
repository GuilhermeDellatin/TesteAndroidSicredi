package com.gfdellatin.testeandroidsicredi.networking.service

import com.gfdellatin.testeandroidsicredi.networking.model.EventResponse
import retrofit2.http.GET

interface EventNetworking {

    @GET("/api/events")
    suspend fun getEvents(): List<EventResponse>

}