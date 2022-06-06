package com.gfdellatin.testeandroidsicredi.domain.repository

import com.gfdellatin.testeandroidsicredi.domain.model.Event

interface EventsRepository {

    suspend fun listEvents(): List<Event>

}