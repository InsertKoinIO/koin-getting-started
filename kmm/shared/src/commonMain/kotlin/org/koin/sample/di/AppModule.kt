package org.koin.sample.di

import org.koin.dsl.module
import org.koin.sample.data.UserRepository
import org.koin.sample.data.UserRepositoryImpl
import org.koin.sample.presenter.KMPUserPresenter

fun appModule() = module {
    single<UserRepository> { UserRepositoryImpl() }
    factory { KMPUserPresenter(get()) }
}