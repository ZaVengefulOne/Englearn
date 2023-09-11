package com.example.englearn.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondFragmentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Что ждёт нас впереди?..."
    }
    val text: LiveData<String> = _text
}