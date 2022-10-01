package org.koin.sample.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.sample.service.UserService
import org.koin.sample.data.UserRepository
import org.koin.sample.data.UserRepositoryImpl

// Constructor DSL
val userModule = module {
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
    singleOf(::UserService)
}

// Classic DSL
//val userModule = module {
//    single<UserRepository> { UserRepositoryImpl() }
//    single { UserService(get()) }
//}