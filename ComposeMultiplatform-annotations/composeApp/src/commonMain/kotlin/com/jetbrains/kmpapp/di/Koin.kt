package com.jetbrains.kmpapp.di

import com.jetbrains.kmpapp.native.PlatformComponent
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes
import org.koin.ksp.generated.*
import org.koin.mp.KoinPlatform

fun initKoin(config : KoinAppDeclaration ?= null) {
    startKoin {
        printLogger()
        includes(config)
        modules(
            AppModule().module,
        )
    }

    val msg = KoinPlatform.getKoin().get<PlatformComponent>().sayHello()
    println("KMP App Platform: $msg")
}
