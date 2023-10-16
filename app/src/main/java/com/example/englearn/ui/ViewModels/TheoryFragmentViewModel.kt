package com.example.englearn.ui.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.englearn.data.database.entity.Article
import com.example.englearn.data.repositories.ArticleRepository
import kotlinx.coroutines.launch

class TheoryFragmentViewModel(application: Application, private val articleRepository: ArticleRepository) : AndroidViewModel(application) {

//    private var repository = ArticleRepository(getApplication()) TODO: Доделать бдшку
    private val _text = MutableLiveData<String>().apply {
        value = "Мы проделали долгий путь...Назад?"

    }
    val text: LiveData<String> = _text

    fun insertNewArticle(number: Int, artName: String, artText: String, isRead: Boolean) {
            val newArticle = Article(number, artName, artText, true)
            articleRepository.insertNewArticle(newArticle)
    }
}