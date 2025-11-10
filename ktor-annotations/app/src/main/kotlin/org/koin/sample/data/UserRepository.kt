package org.koin.sample.data

import org.koin.core.annotation.Single

/**
 * Repository to provide a "Hello" data
 */

interface UserRepository {
    fun findUser(name : String): User?
    fun addUsers(users : List<User>)
}

@Single
class DataRepo()

@Single
class UserRepositoryImpl(val repo : DataRepo) : UserRepository {

    private val _users = arrayListOf<User>()

    override fun findUser(name: String): User? {
        return _users.firstOrNull { it.name == name }
    }

    override fun addUsers(users : List<User>) {
        _users.addAll(users)
    }
}