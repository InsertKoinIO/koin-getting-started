package org.koin.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.get
import org.koin.androidx.compose.koinViewModel
import org.koin.sample.data.DefaultData

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme { App() }
        }
    }
}

@Composable
fun App(){
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center){
        val userName = DefaultData.DEFAULT_USER.name
        FactoryInject(userName)
        ViewModelInject(userName)
    }
}

@Composable
fun FactoryInject(userName : String, presenter: UserStateHolder = get()){
    Text(text = presenter.sayHello(userName), modifier = Modifier.padding(8.dp))
}

@Composable
fun ViewModelInject(userName : String, viewModel: UserViewModel = koinViewModel()){
    Text(text = viewModel.sayHello(userName), modifier = Modifier.padding(8.dp))
}

