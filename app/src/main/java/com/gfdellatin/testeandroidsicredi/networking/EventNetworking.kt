package com.gfdellatin.testeandroidsicredi.networking

import com.gfdellatin.testeandroidsicredi.networking.model.EventResponse
import retrofit2.Call
import retrofit2.http.GET

interface EventNetworking {

    @GET("/api/events")
    suspend fun listEvents(): List<EventResponse>

}