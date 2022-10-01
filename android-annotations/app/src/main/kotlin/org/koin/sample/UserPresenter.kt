package org.koin.sample

import org.koin.core.annotation.Factory
import org.koin.sample.data.UserRepository

/**
 * Simple presenter - use the HelloRepository to "say" hello
 */
@Factory
class UserPresenter(private val repository: UserRepository) {

    fun sayHello(name : String) : String{
        val foundUser = repository.findUser(name)
        return foundUser?.let { "Hello '$it' from $this" } ?: "User '$name' not found!"
    }
}