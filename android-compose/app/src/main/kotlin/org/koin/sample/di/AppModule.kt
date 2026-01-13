package org.koin.sample.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.koin.sample.presentation.UserViewModel
import org.koin.sample.repository.UserRepository
import org.koin.sample.repository.UserRepositoryImpl
import org.koin.sample.service.UserService
import org.koin.sample.service.UserServiceImpl

val appModule = module {
    singleOf(::UserRepositoryImpl){ bind<UserRepository>() }
    singleOf(::UserServiceImpl){ bind<UserService>() }
    viewModelOf(::UserViewModel)
}