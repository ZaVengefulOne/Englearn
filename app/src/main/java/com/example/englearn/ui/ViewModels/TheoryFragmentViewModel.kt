package com.example.englearn.ui.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.englearn.data.repositories.ArticleRepository

class TheoryFragmentViewModel(application: Application) : AndroidViewModel(application) {

//    private var repository = ArticleRepository(getApplication()) TODO: Доделать бдшку
    private val _text = MutableLiveData<String>().apply {
        value = "Мы проделали долгий путь...Назад?"

    }
    val text: LiveData<String> = _text
}