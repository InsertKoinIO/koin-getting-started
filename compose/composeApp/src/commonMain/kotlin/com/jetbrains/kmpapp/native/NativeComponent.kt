package com.jetbrains.kmpapp.native

import com.jetbrains.kmpapp.di.ContextWrapper

expect class NativeComponent(
    contextWrapper: ContextWrapper
) {
    fun getInfo() : String
}