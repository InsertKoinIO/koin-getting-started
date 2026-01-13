package org.koin.sample

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.sample.di.appModule

class MainApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}
