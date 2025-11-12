package com.jetbrains.kmpapp.native

import org.koin.core.annotation.Single

@Single
actual class PlatformComponent actual constructor() {
    actual fun getInfo(): String = "iOS "
}