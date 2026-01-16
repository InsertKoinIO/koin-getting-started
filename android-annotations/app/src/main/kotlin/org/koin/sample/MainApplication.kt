package org.koin.sample

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.annotation.KoinApplication
import org.koin.core.annotation.KoinViewModelScopeApi
import org.koin.core.logger.Level
import org.koin.core.option.viewModelScopeFactory
import org.koin.plugin.module.dsl.startKoin

/**
 * Main Application class for the Koin Annotations sample app.
 *
 * This class uses [@KoinApplication] annotation which automatically:
 * - Discovers all modules annotated with [@Module] and [@Configuration]
 * - Generates the necessary Koin configuration at compile-time via KSP
 * - Loads all modules without requiring manual `modules()` declaration
 *
 * The [startKoin] block only needs to configure Android-specific settings
 * like [androidContext]. All module loading is handled automatically by the
 * [@KoinApplication] annotation processor.
 */
@OptIn(KoinViewModelScopeApi::class)
@KoinApplication
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Just start Koin!
        startKoin<MainApplication> {
            androidContext(this@MainApplication)
            androidLogger(level = Level.DEBUG)
            options(viewModelScopeFactory())
        }
    }
}