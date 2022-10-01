package org.koin.sample

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.ekito.myweatherapp.R
import kotlinx.android.synthetic.main.activity_simple.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.sample.data.DefaultData

class MainActivity : AppCompatActivity() {

    private val presenter: UserPresenter by inject()
    private val viewModel : UserViewModel by viewModel()

    @SuppressLint("SetTextI18n") // just for the text format
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)

        title = "MySimpleActivity"

        val name = DefaultData.DEFAULT_USER.name
        text.text = "${presenter.sayHello(name)} \n ${viewModel.sayHello(name)}"
    }
}
