package org.koin.sample.service

import org.koin.core.annotation.Single
import org.koin.sample.data.DefaultData
import org.koin.sample.data.User
import org.koin.sample.data.UserRepository

@Single
class UserService(private val userRepository: UserRepository) {

    fun getDefaultUser() : User = userRepository.findUser(DefaultData.DEFAULT_USER.name) ?: error("Can't find default user")
    fun saveDefaultUsers() {
        userRepository.addUsers(DefaultData.DEFAULT_USERS)
    }
    fun sayHello() : String {
        return "Hello '${getDefaultUser()}'"
    }
}