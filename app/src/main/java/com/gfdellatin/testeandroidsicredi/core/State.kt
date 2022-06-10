package com.gfdellatin.testeandroidsicredi.core

import com.gfdellatin.testeandroidsicredi.domain.model.Event

sealed class State<out T: Any>  {

    object Loading : State<Nothing>()

    data class Success<out T: Any>(val result: List<Event>) : State<T>()

    data class Error(val error: Throwable) : State<Nothing>()
}