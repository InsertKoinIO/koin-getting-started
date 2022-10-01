package org.koin.sample

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.sample.di.userModule
import org.koin.sample.service.UserService

/**
 * UserListApplication - Application Class
 * use UserRepository
 */
class UserApplication : KoinComponent {

    val userService : UserService by inject()

    init {
        userService.saveDefaultUsers()
    }
    // display our data
    fun sayHello(){
        val user = userService.getDefaultUser()
        val message = "Hello '$user'!"
        println(message)
    }
}

/**
 * run app from here
 */
fun main() {
    startKoin {
        modules(userModule)
    }

    UserApplication().sayHello()
}