package com.example.englearn.ui.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _textButton = MutableLiveData<String>().apply {
        value = "Вперёд, к приключениям!"
    }
    private val _textWelcome = MutableLiveData<String>().apply {
        value = "Добро пожаловать в Poetry Helper!"
    }
    val buttonText: LiveData<String> = _textButton
    val welcomeText: LiveData<String> = _textWelcome
}