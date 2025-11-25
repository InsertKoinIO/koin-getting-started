package org.koin.sample

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.sample.di.appModule

/**
 * Application class that initializes Koin dependency injection framework.
 *
 * This class is responsible for starting Koin when the application launches,
 * configuring it with the Android context and registering all dependency modules.
 *
 * Must be declared in AndroidManifest.xml as the application name.
 */
class MainApplication : Application() {

    /**
     * Called when the application is starting, before any activity, service,
     * or receiver objects have been created.
     *
     * Initializes Koin with:
     * - Android context for Android-specific features
     * - Application module containing all dependency definitions
     */
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}
