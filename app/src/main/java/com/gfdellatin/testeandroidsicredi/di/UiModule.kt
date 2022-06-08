package com.gfdellatin.testeandroidsicredi.di

import com.gfdellatin.testeandroidsicredi.ui.view_model.EventListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object UiModule {

    fun load() {
        loadKoinModules(viewModelModule())
    }

    private fun viewModelModule(): Module {
        return module {
            viewModel { EventListViewModel(get()) }
        }
    }

}