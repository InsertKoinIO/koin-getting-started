package org.koin.sample.kmp

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.sample.presenter.KMPUserPresenter

class KMPUserPresenterHelper : KoinComponent {

    private val userPresenter : KMPUserPresenter by inject()

    fun sayHello(): String = userPresenter.sayHello()
}