package com.gfdellatin.testeandroidsicredi.services

import com.gfdellatin.testeandroidsicredi.domain.model.Event
import com.gfdellatin.testeandroidsicredi.domain.repository.EventsRepository
import com.gfdellatin.testeandroidsicredi.networking.EventNetworking

class EventsRepositoryImpl(
    private val eventsNetworking: EventNetworking
) : EventsRepository {
    override suspend fun listEvents(): List<Event> {

    }
}