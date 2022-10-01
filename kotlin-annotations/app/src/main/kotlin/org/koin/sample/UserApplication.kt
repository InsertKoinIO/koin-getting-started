package org.koin.sample

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.sample.di.AppModule
import org.koin.sample.service.UserService
// generated
import org.koin.ksp.generated.*

/**
 * UserListApplication - Application Class
 * use UserRepository
 */
class UserApplication : KoinComponent {

    val userService: UserService by inject()

    init {
        userService.saveDefaultUsers()
    }

    // display our data
    fun sayHello() {
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
        modules(AppModule().module)
    }

    UserApplication().sayHello()
}