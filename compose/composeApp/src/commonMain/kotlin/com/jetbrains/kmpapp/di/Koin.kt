package com.jetbrains.kmpapp.di

import androidx.navigation.NavBackStackEntry
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
import org.koin.core.annotation.KoinInternalApi
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.KoinDslMarker
import org.koin.core.module.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.core.qualifier.TypeQualifier
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.ScopeDSL
import org.koin.dsl.includes
import org.koin.dsl.module
import org.koin.module.dsl.navigationScope
import org.koin.mp.KoinPlatform
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

val nativeComponentModule = module {
    singleOf(::NativeComponent)
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

    singleOf(::KtorMuseumApi){ bind<MuseumApi>() }
    singleOf(::InMemoryMuseumStorage){ bind<MuseumStorage>() }
    singleOf(::MuseumRepository){
        createdAtStart()
    }
}

class ScopedData {
    @OptIn(ExperimentalUuidApi::class)
    val id : String = Uuid.random().toString()
}

val viewModelModule = module {
    viewModelOf(::ListViewModel)
    viewModelOf(::DetailViewModel)

    navigationScope {
        scoped { ScopedData() }
    }
}

val appModule = module {
    includes(dataModule,viewModelModule, nativeComponentModule)
}

fun initKoin(configuration : KoinAppDeclaration? = null) {
    startKoin {
        includes(configuration)
        modules(
            appModule
        )
        printLogger(Level.DEBUG)
    }

    val platformInfo = KoinPlatform.getKoin().get<NativeComponent>().getInfo()
    println("Running on: $platformInfo")
}
