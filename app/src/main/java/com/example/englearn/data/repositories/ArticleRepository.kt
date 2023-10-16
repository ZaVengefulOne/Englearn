package com.example.englearn.data.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.englearn.data.database.dao.ArticlesDAO
import com.example.englearn.data.database.entity.Article

import com.example.englearn.data.protocols.ArticleProtocol
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArticleRepository(private val articlesDAO: ArticlesDAO) {

    fun insertNewArticle(article: Article){
            articlesDAO.insertNewArticle(article)
        }
    fun getArticles(): List<Article> {
        return articlesDAO.getArticles()
    }
    fun removeArticle(id: Int){
        articlesDAO.deleteArticle(id)
        }
    fun getArticle(id: Int): Article {
           return articlesDAO.getArticle(id)
    }

}