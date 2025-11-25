package org.koin.sample

import android.app.Application
import org.koin.sample.repository.UserRepository
import org.koin.sample.repository.UserRepositoryImpl
import org.koin.sample.service.UserService
import org.koin.sample.service.UserServiceImpl
// import org.koin.ksp.generated.*

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}

// Manual DI container
object DI {

    // UserRepository Impl
    // - Manage all Users data
    val userRepository : UserRepository = UserRepositoryImpl()

    // UserServiceImpl -> UserRepository
    // - Find User by name
    // - Format Message for given user
    val userService : UserService = UserServiceImpl(userRepository)
}