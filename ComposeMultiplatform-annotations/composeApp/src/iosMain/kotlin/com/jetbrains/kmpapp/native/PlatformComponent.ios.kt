package com.jetbrains.kmpapp.native

import org.koin.core.annotation.Factory

@Factory
actual class PlatformComponent {
    actual fun sayHello() : String = "I'm iOS"
}