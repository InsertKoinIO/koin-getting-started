package org.koin.sample.di

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single
import org.koin.plugin.module.dsl.viewModel
import org.koin.sample.presentation.UserViewModel
import org.koin.sample.repository.UserRepository
import org.koin.sample.repository.UserRepositoryImpl
import org.koin.sample.service.UserService
import org.koin.sample.service.UserServiceImpl

val appModule = module {
    single<UserRepositoryImpl>() bind UserRepository::class
    single<UserServiceImpl>() bind UserService::class
    viewModel<UserViewModel>()
}