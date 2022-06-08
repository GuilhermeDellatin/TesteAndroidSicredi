package com.gfdellatin.testeandroidsicredi.services

import com.gfdellatin.testeandroidsicredi.domain.model.Event
import com.gfdellatin.testeandroidsicredi.domain.model.People
import com.gfdellatin.testeandroidsicredi.networking.model.EventResponse
import com.gfdellatin.testeandroidsicredi.networking.model.PeopleResponse

fun EventResponse.toEvent() : Event =
    Event(
        id = this.id,
        people = this.people.map {
            it.toPeople()
        },
        date = this.date,
        description = this.description,
        image = this.image,
        longitude = this.longitude,
        latitude = this.latitude,
        price = this.price,
        title = this.title

    )

fun PeopleResponse.toPeople(): People =
    People(
        id = this.id,
        eventId = this.eventId,
        name = this.name,
        email = this.email
    )