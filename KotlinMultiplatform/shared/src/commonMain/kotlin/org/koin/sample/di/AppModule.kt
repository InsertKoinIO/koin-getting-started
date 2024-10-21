package org.koin.sample.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.sample.UserPresenter
import org.koin.sample.data.UserRepository
import org.koin.sample.data.UserRepositoryImpl

val appModule = module {
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
    factoryOf(::UserPresenter)
}

// Classical DSL version
//val appModule = module {
//    single<UserRepository> { UserRepositoryImpl() }
//    factory { UserPresenter(get()) }
//    viewModel { UserViewModel(get()) }
//}