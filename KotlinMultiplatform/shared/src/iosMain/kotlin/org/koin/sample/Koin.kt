package org.koin.sample

import org.koin.mp.KoinPlatform

fun getUserPresenter() : UserPresenter = KoinPlatform.getKoin().get()
