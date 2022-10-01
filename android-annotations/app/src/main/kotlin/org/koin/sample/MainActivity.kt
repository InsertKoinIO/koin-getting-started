package org.koin.sample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import fr.ekito.myweatherapp.R
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.sample.data.DefaultData

class MainActivity : AppCompatActivity() {

    private val presenter: UserPresenter by inject()
    private val viewModel : UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)

        title = "MySimpleActivity"

        val name = DefaultData.DEFAULT_USER.name
        val textField = findViewById<TextView>(R.id.text)
        textField.text = "${presenter.sayHello(name)} \n ${viewModel.sayHello(name)}"
    }
}
