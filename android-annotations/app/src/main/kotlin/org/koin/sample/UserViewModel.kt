package org.koin.sample

import androidx.lifecycle.ViewModel
import org.koin.android.annotation.KoinViewModel
import org.koin.sample.data.UserRepository

@KoinViewModel
class UserViewModel(private val repository: UserRepository) : ViewModel() {

    fun sayHello(name : String) : String{
        val foundUser = repository.findUser(name)
        return foundUser?.let { "Hello '$it' from $this" } ?: "User '$name' not found!"
    }
}