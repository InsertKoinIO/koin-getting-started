package com.jetbrains.kmpapp.native

import com.jetbrains.kmpapp.context.ContextWrapper
import org.koin.core.annotation.Singleton

@Singleton
expect class NativeComponent() {
    fun getInfo() : String
}

@Singleton
class NativeContextComponent(val ctx : ContextWrapper){

    fun getInfo() : String = "NativeContextComponent with ctx: ${ctx.getContextInfo()}"
}