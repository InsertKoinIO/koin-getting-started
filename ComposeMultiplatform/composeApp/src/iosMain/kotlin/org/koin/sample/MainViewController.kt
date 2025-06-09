package org.koin.sample

import androidx.compose.ui.window.ComposeUIViewController
import org.koin.sample.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) { App() }