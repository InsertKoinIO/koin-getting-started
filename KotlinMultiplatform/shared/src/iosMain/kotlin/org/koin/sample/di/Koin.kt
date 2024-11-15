package org.koin.sample.di

import org.koin.mp.KoinPlatform
import org.koin.sample.UserPresenter

fun getUserPresenter() : UserPresenter = KoinPlatform.getKoin().get()
