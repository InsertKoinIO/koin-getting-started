package com.jetbrains.kmpapp.native

import android.content.Context
import com.jetbrains.kmpapp.context.ContextWrapper
import org.koin.core.annotation.Singleton

@Singleton
class AndroidContextWrapper(val context: Context) : ContextWrapper {
    override fun getContextInfo(): String = "Android Context: $context"
}