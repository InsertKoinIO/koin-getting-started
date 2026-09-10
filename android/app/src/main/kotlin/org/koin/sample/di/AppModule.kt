package org.koin.sample.di

import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.plugin.module.dsl.factory
import org.koin.plugin.module.dsl.single
import org.koin.plugin.module.dsl.viewModel
import org.koin.sample.presentation.UserPresenter
import org.koin.sample.presentation.UserViewModel
import org.koin.sample.repository.UserRepository
import org.koin.sample.repository.UserRepositoryImpl
import org.koin.sample.service.UserService
import org.koin.sample.service.UserServiceImpl

/**
 * Main Koin dependency injection module for the application.
 *
 * This module defines all application dependencies using Koin's Constructor DSL:
 * - [UserRepositoryImpl] - Repository implementation bound to [UserRepository] interface (singleton)
 * - [UserServiceImpl] - Service implementation bound to [UserService] interface (singleton)
 * - [UserViewModel] - ViewModel for managing user-related UI state (viewModel scope)
 * - [UserPresenter] - Presenter for user-related presentation logic (factory scope)
 *
 * Dependency scopes:
 * - singleOf: Creates a single instance throughout the application lifecycle
 * - viewModelOf: Creates a ViewModel instance tied to the Android ViewModel lifecycle
 * - factoryOf: Creates a new instance each time it's requested
 */
val appModule = module {
    viewModel { UserViewModel(get()) }
    factoryOf(::UserPresenter)
    single { UserServiceImpl(get()) } bind UserService::class
    single<UserRepositoryImpl>() bind UserRepository::class
}