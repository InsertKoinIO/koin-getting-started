package com.jetbrains.kmpapp.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton

@Module
@ComponentScan
actual class PlatformComponentModule

@Singleton
class AndroidPlatformComponent : PlatformComponent {
    override fun getInfo(): String = "Android PlatformComponent"
}