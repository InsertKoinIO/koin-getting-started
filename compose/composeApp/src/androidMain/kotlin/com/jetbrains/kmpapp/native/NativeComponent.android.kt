package com.jetbrains.kmpapp.native

import com.jetbrains.kmpapp.di.ContextWrapper

actual class NativeComponent actual constructor(
    private val contextWrapper: ContextWrapper
) {
    actual fun getInfo(): String = "Android OS - Ctx:$contextWrapper - Android context:${contextWrapper.context}"
}