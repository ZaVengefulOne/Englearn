package com.example.englearn.ui.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RhymeFragmentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Что ждёт нас впереди?..."
    }
    val text: LiveData<String> = _text
}