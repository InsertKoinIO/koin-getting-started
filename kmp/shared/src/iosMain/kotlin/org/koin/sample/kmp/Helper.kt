package org.koin.sample.kmp

import org.koin.core.context.startKoin
import org.koin.sample.data.DefaultData
import org.koin.sample.data.UserRepository
import org.koin.sample.di.appModule

fun initKoin() {
    // start Koin
    val koinApp = startKoin {
        modules(appModule())
    }.koin

    // load default users
    koinApp.get<UserRepository>().addUsers(DefaultData.DEFAULT_USERS)
}