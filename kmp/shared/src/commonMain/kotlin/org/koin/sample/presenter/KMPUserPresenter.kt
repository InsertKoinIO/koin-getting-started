package org.koin.sample.presenter

import org.koin.sample.data.DefaultData
import org.koin.sample.data.UserRepository

class KMPUserPresenter(private val repository: UserRepository) {

    fun sayHello() : String {
        val name = DefaultData.DEFAULT_USER.name
        val foundUser = repository.findUser(name)
        return foundUser?.let { "Hello '$it' from $this" } ?: "User '$name' not found!"
    }
}