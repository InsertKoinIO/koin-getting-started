package org.koin.sample.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(){
    startKoin(
        koinSharedConfiguration()
    )
}

fun koinSharedConfiguration() : KoinAppDeclaration = {
    modules(appModule)
}