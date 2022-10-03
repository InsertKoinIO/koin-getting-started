package com.example.helloworldkmp.android.di

import org.koin.sample.AndroidUserViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val androidModule = module {
    viewModelOf(::AndroidUserViewModel)
}