package org.koin.sample.kmp

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.sample.data.DefaultData
import org.koin.sample.data.UserRepository
import org.koin.sample.di.appModule
import org.koin.sample.presenter.KMPUserPresenter

class KMPUserPresenterHelper : KoinComponent {
    private val userPresenter : KMPUserPresenter by inject()
    fun sayHello(): String = userPresenter.sayHello()
}

fun initKoin(){
    val koinApp = startKoin {
        modules(appModule())
    }.koin
    koinApp.get<UserRepository>().addUsers(DefaultData.DEFAULT_USERS)
}