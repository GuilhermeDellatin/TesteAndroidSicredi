package com.gfdellatin.testeandroidsicredi.domain.use_case

import com.gfdellatin.testeandroidsicredi.domain.model.Event
import com.gfdellatin.testeandroidsicredi.domain.repository.EventsRepository
import com.gfdellatin.testeandroidsicredi.domain.use_cases.ListEventsUseCase
import io.mockk.MockKAnnotations
import io.mockk.mockk
import io.mockk.mockkClass
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Before

class EventListUseCaseTest {

    private lateinit var listEventsUseCase: ListEventsUseCase

    private val event = mockkClass(Event::class)
    private val eventsRepository: EventsRepository = mockk()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        listEventsUseCase = ListEventsUseCase(eventsRepository)
    }

    @After
    fun tearDown() = unmockkAll()

}