package org.koin.sample.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinConfiguration
import org.koin.dsl.includes
import org.koin.dsl.koinConfiguration
import org.koin.dsl.module
import org.koin.sample.UserViewModel
import org.koin.sample.data.UserRepository
import org.koin.sample.data.UserRepositoryImpl

expect fun nativeConfig() : KoinConfiguration

val koinConfig = koinConfiguration {
    includes(nativeConfig())
    modules(appModule)
}

val appModule = module {
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
    viewModelOf(::UserViewModel)
}