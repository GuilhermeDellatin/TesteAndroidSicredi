package com.gfdellatin.testeandroidsicredi.services

import com.gfdellatin.testeandroidsicredi.core.RemoteException
import com.gfdellatin.testeandroidsicredi.domain.repository.EventsRepository
import com.gfdellatin.testeandroidsicredi.networking.service.EventNetworking
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class EventsRepositoryImpl(
    private val eventsNetworking: EventNetworking
) : EventsRepository {
    override suspend fun getEvents() = flow {
        try {
            val eventList = eventsNetworking.getEvents().map {
                it.toEvent()
            }
            emit(eventList)
        } catch (e: HttpException) {
            throw RemoteException("Unable to connect Api")
        }
    }

}