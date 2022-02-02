package org.koin.sample

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.ekito.myweatherapp.R
import kotlinx.android.synthetic.main.activity_simple.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyActivity : AppCompatActivity() {

    // Inject MyPresenter
    val myPresenter: MyPresenter by inject()
    // Inject MyViewModel
    val myViewModel : MyViewModel by viewModel()

    @SuppressLint("SetTextI18n") // just for the text format
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)

        title = "MySimpleActivity"
        text.text = "${myPresenter.sayHello()} \n ${myViewModel.sayHello()}"
    }
}
