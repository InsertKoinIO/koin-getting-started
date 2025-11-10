package org.koin.sample.service

import org.koin.sample.data.User
import org.koin.sample.data.UsersData.DEFAULT_USER
import org.koin.sample.data.UsersData.DEFAULT_USERS
import org.koin.sample.repository.UserRepository

interface UserService {
    fun getDefaultUser() : User
    fun loadDefaultUsers()
}

class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    override fun getDefaultUser() : User = userRepository.findUser(DEFAULT_USER.name) ?: error("Can't find default user")

    override fun loadDefaultUsers() {
        userRepository.addUsers(DEFAULT_USERS)
    }
}