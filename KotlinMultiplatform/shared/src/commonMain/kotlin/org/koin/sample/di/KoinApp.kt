package org.koin.sample.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

fun initKoin(){
    startKoin(
        koinConfiguration()
    )
}

fun koinConfiguration() : KoinApplication.() -> Unit = {
    printLogger(Level.DEBUG)
    modules(appModule)
}