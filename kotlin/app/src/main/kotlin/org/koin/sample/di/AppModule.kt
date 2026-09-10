package org.koin.sample.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single
import org.koin.sample.UserApplication
import org.koin.sample.repository.UserRepository
import org.koin.sample.repository.UserRepositoryImpl
import org.koin.sample.service.UserService
import org.koin.sample.service.UserServiceImpl

/**

class UserApplication(
    private val userService: UserService
)

class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService

class UserRepositoryImpl : UserRepository

 */
val appModule = module {
    singleOf(::UserApplication)
    single { UserServiceImpl(get()) } bind UserService::class
    single<UserRepositoryImpl>() bind UserRepository::class
}