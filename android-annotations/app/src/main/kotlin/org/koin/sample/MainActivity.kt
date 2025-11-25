package org.koin.sample

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.koin.android.ext.android.inject
import org.koin.sample.presentation.UserViewModel

/**
 * Main activity demonstrating Koin dependency injection in Android.
 *
 * This activity showcases two different approaches to dependency injection:
 * - Using [inject] for standard dependency injection (Presenter pattern)
 * - Using [viewModel] for Android ViewModel injection (MVVM pattern)
 *
 * Both the presenter and viewModel are automatically injected by Koin
 * based on the definitions in the appModule.
 */
class MainActivity : AppCompatActivity() {

    private val viewModel : UserViewModel by viewModels {
        // You define how to build the ViewModel here
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return UserViewModel(DI.userService) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
        title = "Koin Annotations Sample"

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val sayHelloButton = findViewById<Button>(R.id.sayHelloButton)
        val textField = findViewById<TextView>(R.id.text)

        // Set up button click listener to get user input and display greeting
        sayHelloButton.setOnClickListener {
            val userName = nameInput.text.toString().trim().ifEmpty { "Alice" }
            val helloFromViewModel = viewModel.sayHello(userName)
            textField.text = getString(R.string.hello_message, helloFromViewModel)
        }
    }
}
