package org.koin.sample

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // single instance of HelloRepository
    single<HelloRepository> { HelloRepositoryImpl() }

    // Simple Presenter Factory
    factory { MyPresenter(get()) }

    // MyViewModel ViewModel
    viewModel { MyViewModel(get()) }
}