package com.jetbrains.kmpapp.di

import org.koin.core.module.Module
import org.koin.dsl.module

actual val nativeContextModule: Module = module {
    single { ContextWrapper() }
}