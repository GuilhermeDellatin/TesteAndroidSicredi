package com.gfdellatin.testeandroidsicredi.networking.service

import com.gfdellatin.testeandroidsicredi.networking.EventNetworking
import com.gfdellatin.testeandroidsicredi.networking.model.EventResponse
import kotlinx.coroutines.CoroutineDispatcher

class EventNetworkingImpl(
    private val networking: EventNetworking,
    private val dispatcher: CoroutineDispatcher
) : EventNetworking {
    override suspend fun listEvents(): List<EventResponse> {
        return networking.listEvents()
    }
}