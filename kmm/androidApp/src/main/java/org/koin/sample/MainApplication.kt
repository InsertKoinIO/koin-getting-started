package org.koin.sample

import android.app.Application
import com.example.helloworldkmp.android.di.androidModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.sample.data.DefaultData
import org.koin.sample.data.UserRepository
import org.koin.sample.di.appModule

class MainApplication : Application() {

    private val userRepository : UserRepository by inject()

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
            modules(appModule() + androidModule)
        }

        userRepository.addUsers(DefaultData.DEFAULT_USERS)
    }
}