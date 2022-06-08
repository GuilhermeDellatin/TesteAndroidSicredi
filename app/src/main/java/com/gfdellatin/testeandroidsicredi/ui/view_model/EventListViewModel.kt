package com.gfdellatin.testeandroidsicredi.ui.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gfdellatin.testeandroidsicredi.domain.model.Event
import com.gfdellatin.testeandroidsicredi.domain.use_cases.ListEventsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class EventListViewModel(
    private val listEventsUseCase: ListEventsUseCase,
) : ViewModel() {

    private val _progressBar = MutableLiveData<Boolean>(false)
    val progressBar: LiveData<Boolean> get() = _progressBar

    private val _eventsLiveData = MutableLiveData<State>()
    val eventsLiveData: LiveData<State> get() = _eventsLiveData

    fun showProgressBar() {
        _progressBar.value = true
    }

    fun hideProgressBar() {
        _progressBar.value = false
    }

    init {
        getEventList()
    }

    private fun getEventList() {
        viewModelScope.launch {
            listEventsUseCase()
                .flowOn(Dispatchers.Main)
                .onStart {
                    _eventsLiveData.postValue(State.Loading)
                }
                .catch {
                    _eventsLiveData.postValue(State.Error(it))
                }
                .collect {
                    _eventsLiveData.postValue(State.Success(it))
                }
        }
    }

    sealed class State {
        object Loading : State()
        data class Success(val list: List<Event>) : State()
        data class Error(val error: Throwable) : State()
    }

}