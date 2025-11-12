package com.jetbrains.kmpapp.di

import com.jetbrains.kmpapp.data.DataModule
import com.jetbrains.kmpapp.native.PlatformComponent
import com.jetbrains.kmpapp.native.PlatformComponentModule
import com.jetbrains.kmpapp.screens.ViewModelModule
import org.koin.core.annotation.Configuration
import org.koin.core.annotation.KoinApplication
import org.koin.core.annotation.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes
import org.koin.ksp.generated.startKoin
import org.koin.mp.KoinPlatform

@Configuration
@Module(includes = [DataModule::class, ViewModelModule::class, PlatformComponentModule::class])
class AppModule

@KoinApplication
object KoinApp

fun initKoin(configuration : KoinAppDeclaration? = null) {
    KoinApp.startKoin {
        includes(configuration)
    }

    val platformInfo = KoinPlatform.getKoin().get<PlatformComponent>().getInfo()
    println("Running on: $platformInfo")
}
