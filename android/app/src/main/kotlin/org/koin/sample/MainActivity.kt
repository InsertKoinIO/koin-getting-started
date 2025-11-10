package org.koin.sample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.sample.presentation.UserPresenter
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

    /**
     * UserPresenter injected using Koin's inject() delegate.
     * Creates a new instance each time (factory scope).
     */
    private val presenter: UserPresenter by inject()

    /**
     * UserViewModel injected using Koin's viewModel() delegate.
     * Lifecycle-aware and survives configuration changes.
     */
    private val viewModel : UserViewModel by viewModel()

    /**
     * Initializes the activity and displays greeting messages from both
     * the Presenter and ViewModel to demonstrate both injection approaches.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)

        title = "MySimpleActivity"
        val textField = findViewById<TextView>(R.id.text)

        val defaultName = "Alice"

        // Get greeting messages from both presentation components
        val helloFromPresenter = presenter.sayHello(defaultName)
        val helloFromViewModel = viewModel.sayHello(defaultName)

        // Display both messages using a string resource
        textField.text = getString(R.string.hello_messages, helloFromPresenter, helloFromViewModel)
    }
}
