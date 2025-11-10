package org.koin.sample.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.sample.UserApplication
import org.koin.sample.repository.UserRepository
import org.koin.sample.repository.UserRepositoryImpl
import org.koin.sample.service.UserService
import org.koin.sample.service.UserServiceImpl

// Constructor DSL
val appModule = module {
    singleOf(::UserApplication)
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
    singleOf(::UserServiceImpl) { bind<UserService>() }
}