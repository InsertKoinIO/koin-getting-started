package org.koin.sample

import org.koin.sample.data.UserRepository
import kotlin.let

/**
 * Simple presenter - use the HelloRepository to "say" hello
 */
class UserPresenter(private val repository: UserRepository) {

    fun sayHello(name : String) : String{
        val foundUser = repository.findUser(name)
        val platform = getPlatform()
        return foundUser?.let { "Hello '$it' from ${platform.name}" } ?: "User '$name' not found!"
    }
}