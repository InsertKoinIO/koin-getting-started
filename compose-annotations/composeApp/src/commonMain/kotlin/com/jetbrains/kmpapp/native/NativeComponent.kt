package com.jetbrains.kmpapp.native

import org.koin.core.annotation.Single

@Single
expect class NativeComponent() {
    fun getInfo() : String
}