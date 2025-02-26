package org.koin.sample

import org.koin.core.annotation.Single
import java.util.UUID

@Single
class SharedPresenter {
    val id : String = UUID.randomUUID().toString()

    fun sayHello(name: String): String{
        return "Hello '$name' from SharedPresenter($id)"
    }
}