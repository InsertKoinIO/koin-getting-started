package org.koin.sample.di

import org.koin.core.KoinApplication

actual fun nativeConfig(): KoinApplication.() -> Unit = {
    printLogger()
}
