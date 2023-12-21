package org.koin.sample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.helloworldkmp.android.R
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.sample.presenter.KMPUserPresenter

class MainActivity : AppCompatActivity() {

    private val presenter: KMPUserPresenter by inject()
    private val viewModel : AndroidUserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.text_view)
        textView.text = presenter.sayHello()+"\n\n"+viewModel.sayHello()
    }
}
