package com.jetbrains.kmpapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.LaunchedEffect
import com.jetbrains.kmpapp.screens.list.ListViewModel
import org.koin.compose.viewmodel.koinActivityViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("MainActivity:viewModelStore: -> ${this.viewModelStore}")

        enableEdgeToEdge()
        setContent {
            // Remove when https://issuetracker.google.com/issues/364713509 is fixed
            LaunchedEffect(isSystemInDarkTheme()) {
                enableEdgeToEdge()
            }
            val vm = koinActivityViewModel<ListViewModel>()

            println("MainActivity:vm: -> $vm")
            App()
        }
    }
}
