package com.gfdellatin.testeandroidsicredi.ui.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gfdellatin.testeandroidsicredi.core.State
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

    private val _progressLiveData = MutableLiveData<Boolean>()
    val progressLiveData: LiveData<Boolean> get() = _progressLiveData

    private val _eventsLiveData = MutableLiveData<State<List<Event>>>()
    val eventsLiveData: LiveData<State<List<Event>>> get() = _eventsLiveData

    fun showProgressBar() {
        _progressLiveData.value = true
    }

    fun hideProgressBar() {
        _progressLiveData.value = false
    }

    init {
        getEventList()
    }

    fun getEventList() {
        viewModelScope.launch {
            listEventsUseCase()
                .flowOn(Dispatchers.Main)
                .onStart {
                    _progressLiveData.value = true
                    _eventsLiveData.postValue(State.Loading)
                }
                .catch {
                    _progressLiveData.value = false
                    _eventsLiveData.postValue(State.Error(it))
                }
                .collect {
                    _progressLiveData.value = false
                    _eventsLiveData.postValue(State.Success(it))
                }
        }
    }

}