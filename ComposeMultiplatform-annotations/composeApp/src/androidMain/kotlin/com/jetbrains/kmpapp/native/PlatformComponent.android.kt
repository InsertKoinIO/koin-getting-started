package com.jetbrains.kmpapp.native

import android.content.Context
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Single

@Factory
actual class PlatformComponent(val context: Context){
    
    actual fun sayHello() : String = "I'm Android - $context"
}