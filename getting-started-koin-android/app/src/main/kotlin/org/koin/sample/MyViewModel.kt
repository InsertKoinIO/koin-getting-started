package org.koin.sample

import androidx.lifecycle.ViewModel
import org.koin.sample.HelloRepository

class MyViewModel(val repo: HelloRepository) : ViewModel() {

    fun sayHello() = "${repo.giveHello()} from MyViewModel"
}