package com.gfdellatin.testeandroidsicredi.factory

import com.gfdellatin.testeandroidsicredi.domain.model.Event
import com.gfdellatin.testeandroidsicredi.domain.model.People


class EventFactory {

    fun createEvent() = Event(
        id = "1",
        people = listOf(createPeople()),
        date = 1534784400000,
        description = "Hackathon Social...",
        image = "https://static.wixstatic.com/media/579ac9_81e9766eaa2741a284e7a7f729429022~mv2.png",
        longitude = "-51.2148497",
        latitude = "-30.037878",
        price = 59.99,
        title = "Hackathon Social Woop Sicredi"
    )

    fun createPeople() =  People(
        id = "1",
        eventId = "1",
        name = "TestePessoa",
        email = "testepessoa@gmail.com"
    )

}