package org.koin.sample.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.sample.UserStateHolder
import org.koin.sample.UserViewModel
import org.koin.sample.data.UserRepository
import org.koin.sample.data.UserRepositoryImpl

val appModule = module {
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
    factoryOf(::UserStateHolder)
    viewModelOf(::UserViewModel)
}

// Classical DSL version
//val appModule = module {
//    single<HelloRepository> { HelloRepositoryImpl() }
//    factory { MyPresenter(get()) }
//    viewModel { MyViewModel(get()) }
//}