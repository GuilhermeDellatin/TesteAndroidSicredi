package com.gfdellatin.testeandroidsicredi.di

import android.util.Log
import com.gfdellatin.testeandroidsicredi.domain.repository.EventsRepository
import com.gfdellatin.testeandroidsicredi.networking.service.EventNetworking
import com.gfdellatin.testeandroidsicredi.services.EventsRepositoryImpl
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModules {

    private const val BASE_URL = "https://5f5a8f24d44d640016169133.mockapi.io"
    private const val OK_HTTP = "OkHttp"

    fun load() {
        loadKoinModules(networkModules() + repositoriesModule())
    }

    private fun networkModules() : Module {
        return module {
            single {
                val interceptor = HttpLoggingInterceptor {
                    Log.e(OK_HTTP, it)
                }
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()
            }
            single {
                GsonConverterFactory.create(GsonBuilder().create())
            }
            single {
                createService<EventNetworking>(get(), get())
            }
        }
    }

    private fun repositoriesModule() : Module {
        return module {
            single<EventsRepository> { EventsRepositoryImpl(get()) }
        }
    }

    private inline fun <reified T> createService(client: OkHttpClient, factory: GsonConverterFactory): T {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(factory)
            .build().create(T::class.java)
    }

}