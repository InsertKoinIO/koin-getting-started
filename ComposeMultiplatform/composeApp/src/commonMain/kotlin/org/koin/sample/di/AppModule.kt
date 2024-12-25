package org.koin.sample.di

import org.koin.core.KoinApplication
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.koin.sample.UserViewModel
import org.koin.sample.data.UserRepository
import org.koin.sample.data.UserRepositoryImpl

expect fun nativeConfig() : KoinApplication.() -> Unit

val appModule = module {
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
    viewModelOf(::UserViewModel)
}
