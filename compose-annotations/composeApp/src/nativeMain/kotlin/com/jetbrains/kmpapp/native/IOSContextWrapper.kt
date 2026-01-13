package com.jetbrains.kmpapp.native

import com.jetbrains.kmpapp.context.ContextWrapper
import org.koin.core.annotation.Singleton

@Singleton
class IOSContextWrapper : ContextWrapper {
    override fun getContextInfo(): String = "iOS Context"
}