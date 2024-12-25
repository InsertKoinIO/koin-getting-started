package org.koin.sample.di

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.sample.MainApplication

actual fun nativeConfig(): KoinApplication.() -> Unit = {
    androidLogger()
    androidContext(MainApplication.instance ?: error("No Android application context set"))
}
