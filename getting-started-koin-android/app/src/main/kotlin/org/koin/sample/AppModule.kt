package org.koin.sample

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {

    // single instance of HelloRepository
    singleOf(::HelloRepositoryImpl) { bind<HelloRepository>() }

    // Simple Presenter Factory
    factoryOf(::MyPresenter)

    // MyViewModel ViewModel
    viewModelOf(::MyViewModel)
}

// Classical DSL
//val appModule = module {
//    // single instance of HelloRepository
//    single<HelloRepository> { HelloRepositoryImpl() }
//
//    // Simple Presenter Factory
//    factory { MyPresenter(get()) }
//
//    // MyViewModel ViewModel
//    viewModel { MyViewModel(get()) }
//}