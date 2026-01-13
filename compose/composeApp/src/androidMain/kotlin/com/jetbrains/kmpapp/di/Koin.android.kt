package com.jetbrains.kmpapp.di

import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single

class AndroidComponent() : PlatformComponent {
    override fun getInfo(): String = "Android OS"
}

actual fun platformModule() : Module = module {
    single<AndroidComponent>() bind PlatformComponent::class
}