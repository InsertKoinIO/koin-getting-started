package com.jetbrains.kmpapp.native

import org.koin.core.annotation.Factory

@Factory
expect class PlatformComponent() {
    fun sayHello() : String
}