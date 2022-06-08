package com.gfdellatin.testeandroidsicredi.domain.use_cases

import com.gfdellatin.testeandroidsicredi.core.UseCase
import com.gfdellatin.testeandroidsicredi.domain.model.Event
import com.gfdellatin.testeandroidsicredi.domain.repository.EventsRepository
import kotlinx.coroutines.flow.Flow

class ListEventsUseCase(
    private val repository: EventsRepository
) : UseCase.NoParam<List<Event>>() {

    override suspend fun execute(): Flow<List<Event>> {
        return repository.getEvents()
    }

}