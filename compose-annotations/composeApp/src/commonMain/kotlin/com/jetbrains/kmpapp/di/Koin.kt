package com.jetbrains.kmpapp.di

import com.jetbrains.kmpapp.di.DataModule
import com.jetbrains.kmpapp.native.NativeComponent
import com.jetbrains.kmpapp.native.NativeComponentModule
import com.jetbrains.kmpapp.screens.ViewModelModule
import org.koin.core.annotation.Configuration
import org.koin.core.annotation.KoinApplication
import org.koin.core.annotation.Module
import org.koin.core.logger.Level
import org.koin.plugin.module.dsl.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes
import org.koin.mp.KoinPlatform

interface PlatformComponent {
    fun getInfo(): String
}

@Module
expect class PlatformComponentModule

@Module(includes = [ViewModelModule::class, NativeComponentModule::class, PlatformComponentModule::class])
@Configuration
class AppModule

@KoinApplication
object KoinApp

fun initKoin(configuration : KoinAppDeclaration? = null) {
    startKoin<KoinApp> {
        printLogger(Level.DEBUG)
        includes(configuration)
    }

    val nativeComponent = KoinPlatform.getKoin().get<NativeComponent>().getInfo()
    println("-- Expect/Actual Definition -- Running on: $nativeComponent")

    val platformInfo = KoinPlatform.getKoin().get<PlatformComponent>().getInfo()
    println("-- Expect/Actual Module's + Interface Definition -- Running on: $platformInfo")
}
