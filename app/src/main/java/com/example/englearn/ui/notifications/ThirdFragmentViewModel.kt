package com.example.englearn.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ThirdFragmentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Мы проделали долгий путь...Назад?"

    }
    val text: LiveData<String> = _text
}