package com.example.countdowntimer_kotlinflows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val countDownFlow = flow<Int> {
        val startValue = 10
        emit(startValue)
        var currentValue = startValue
        while (currentValue>0){
            delay(1000L)
            currentValue--
            emit(currentValue)
        }
    }

    init {
        collectFlow()
    }

    private fun collectFlow ()  {
        viewModelScope.launch {
            countDownFlow.collectLatest{
                time ->
                delay(1100L)
                println("Current Time = $time")
            }
        }
    }
}