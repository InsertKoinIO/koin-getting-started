package org.koin.sample.data

data class User(val name : String)

object UsersData {
    val DEFAULT_USER = User("Koin")
    val DEFAULT_USERS = listOf(DEFAULT_USER)
}