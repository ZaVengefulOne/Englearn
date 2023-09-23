package com.example.englearn.ui.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TheoryFragmentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Мы проделали долгий путь...Назад?"

    }
    val text: LiveData<String> = _text
}