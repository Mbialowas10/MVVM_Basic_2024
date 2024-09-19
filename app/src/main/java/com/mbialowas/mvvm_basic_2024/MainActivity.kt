package com.mbialowas.mvvm_basic_2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mbialowas.mvvm_basic_2024.ui.theme.MVVM_Basic_2024Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVM_Basic_2024Theme {
                // now we can use the view model
                val viewModel:AppViewModel = ViewModelProvider(this)[AppViewModel::class.java]

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counter(viewModel=viewModel, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Counter(
    modifier: Modifier = Modifier,
    viewModel: AppViewModel
){
    var count by remember {
        viewModel.counter
    }
    Button(
        modifier = modifier,
        onClick = {
            viewModel.incrementCounter()
        }
    ){
        Text(text = "This button has been clicked ${count} times")
    }
}

