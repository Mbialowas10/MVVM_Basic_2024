package com.mbialowas.mvvm_basic_2024

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel() {

    var counter = mutableStateOf(0)
        private set // prevent modification from outside of the view model

    fun incrementCounter() {
        counter.value++
    }

}