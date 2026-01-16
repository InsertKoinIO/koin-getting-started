package org.koin.sample.di

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single
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
 *
 * All dependencies are created as singletons to ensure a single instance
 * throughout the application lifecycle.
 */
val appModule = module {
    single<UserRepositoryImpl>() bind UserRepository::class
    single<UserServiceImpl>() bind UserService::class
}