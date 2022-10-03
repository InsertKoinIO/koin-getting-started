package org.koin.sample

import androidx.lifecycle.ViewModel
import org.koin.sample.data.DefaultData
import org.koin.sample.data.UserRepository

class AndroidUserViewModel(private val repository: UserRepository) : ViewModel() {

    fun sayHello() : String{
        val name = DefaultData.DEFAULT_USER.name
        val foundUser = repository.findUser(name)
        return foundUser?.let { "Hello '$it' from $this" } ?: "User '$name' not found!"
    }
}