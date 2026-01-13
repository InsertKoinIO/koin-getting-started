package com.jetbrains.kmpapp.di

import com.jetbrains.kmpapp.data.InMemoryMuseumStorage
import com.jetbrains.kmpapp.data.KtorMuseumApi
import com.jetbrains.kmpapp.data.MuseumApi
import com.jetbrains.kmpapp.data.MuseumRepository
import com.jetbrains.kmpapp.data.MuseumStorage
import com.jetbrains.kmpapp.native.NativeComponent
import com.jetbrains.kmpapp.screens.detail.DetailViewModel
import com.jetbrains.kmpapp.screens.list.ListViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.includes
import org.koin.dsl.module
import org.koin.mp.KoinPlatform
import org.koin.plugin.module.dsl.single
import org.koin.plugin.module.dsl.viewModel

interface PlatformComponent {
    fun getInfo(): String
}

expect fun platformModule() : Module

val nativeComponentModule = module {
    single<NativeComponent>()
}

val dataModule = module {
    single {
        val json = Json { ignoreUnknownKeys = true }
        HttpClient {
            install(ContentNegotiation) {
                // TODO Fix API so it serves application/json
                json(json, contentType = ContentType.Any)
            }
        }
    }

    single<KtorMuseumApi>() bind MuseumApi::class
    single<InMemoryMuseumStorage>() bind MuseumStorage::class
    single<MuseumRepository>() withOptions { createdAtStart() }
}

val viewModelModule = module {
    viewModel<ListViewModel>()
    viewModel<DetailViewModel>()
}

val appModule = module {
    includes(dataModule, viewModelModule, nativeComponentModule, platformModule())
}

fun initKoin(configuration: KoinAppDeclaration? = null) {
    startKoin {
        includes(configuration)
        modules(appModule)
        printLogger(Level.DEBUG)
    }

    val nativeComponent = KoinPlatform.getKoin().get<NativeComponent>().getInfo()
    println("-- Expect/Actual Definition -- Running on: $nativeComponent")

    val platformInfo = KoinPlatform.getKoin().get<PlatformComponent>().getInfo()
    println("-- Expect/Actual Module's + Interface Definition -- Running on: $platformInfo")
}
