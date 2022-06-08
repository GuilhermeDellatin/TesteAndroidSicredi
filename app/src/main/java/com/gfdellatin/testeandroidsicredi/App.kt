package com.gfdellatin.testeandroidsicredi

import android.app.Application
import com.gfdellatin.testeandroidsicredi.di.DomainModule
import com.gfdellatin.testeandroidsicredi.di.NetworkModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }
        NetworkModules.load()
        DomainModule.load()

    }
}