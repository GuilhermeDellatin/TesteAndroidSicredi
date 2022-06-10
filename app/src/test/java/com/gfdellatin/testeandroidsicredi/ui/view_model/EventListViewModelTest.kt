package com.gfdellatin.testeandroidsicredi.ui.view_model

import com.gfdellatin.testeandroidsicredi.domain.use_cases.ListEventsUseCase
import com.gfdellatin.testeandroidsicredi.factory.EventFactory
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before

@ExperimentalCoroutinesApi
class EventListViewModelTest {


    private val listEventsUseCase = mockk<ListEventsUseCase>()

    private lateinit var eventListViewModel: EventListViewModel

    private val eventsFactory = EventFactory()

    private val listEvents = listOf(
        eventsFactory.createEvent()
    )

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        eventListViewModel = EventListViewModel(
            listEventsUseCase
        )
    }

    @After
    fun tearDown() = clearAllMocks()
}