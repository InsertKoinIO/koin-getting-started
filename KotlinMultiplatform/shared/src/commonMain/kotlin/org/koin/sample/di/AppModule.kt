package org.koin.sample.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.sample.UserPresenter
import org.koin.sample.data.UserRepository
import org.koin.sample.data.UserRepositoryImpl
import org.koin.sample.getPlatform

val appModule = module {
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
    factoryOf(::UserPresenter)
    factory { getPlatform(this) }
}