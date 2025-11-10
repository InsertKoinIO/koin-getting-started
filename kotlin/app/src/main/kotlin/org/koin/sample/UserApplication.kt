package org.koin.sample

import org.koin.core.context.startKoin
import org.koin.mp.KoinPlatform
import org.koin.sample.di.appModule
import org.koin.sample.service.UserService

/**
 * UserListApplication - Application Class
 * use UserRepository
 */
class UserApplication(
    private val userService: UserService
) {

    init {
        userService.loadDefaultUsers()
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
        modules(appModule)
    }

    KoinPlatform.getKoin().get<UserApplication>().sayHello()
}