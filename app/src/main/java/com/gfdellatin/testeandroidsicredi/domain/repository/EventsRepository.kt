package com.gfdellatin.testeandroidsicredi.domain.repository

import com.gfdellatin.testeandroidsicredi.domain.model.Event
import kotlinx.coroutines.flow.Flow

interface EventsRepository {

    suspend fun getEvents(): Flow<List<Event>>

}