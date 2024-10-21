package org.koin.sample.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.sample.service.UserService
import org.koin.sample.data.UserRepository
import org.koin.sample.data.UserRepositoryImpl

// Constructor DSL
@Module
@ComponentScan("org.koin.sample")
class AppModule

//val appModule = module {
//    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
//    singleOf(::UserService)
//}

// Classic DSL
//val appModule = module {
//    single<UserRepository> { UserRepositoryImpl() }
//    single { UserService(get()) }
//}