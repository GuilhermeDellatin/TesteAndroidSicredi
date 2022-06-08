package com.gfdellatin.testeandroidsicredi.di

import com.gfdellatin.testeandroidsicredi.domain.use_cases.ListEventsUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {

    fun load() {
        loadKoinModules(useCaseModule())
    }

    private fun useCaseModule(): Module {
        return module {
            factory { ListEventsUseCase(get()) }
        }
    }

}