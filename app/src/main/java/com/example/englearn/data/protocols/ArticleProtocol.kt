//package com.example.englearn.data.protocols
//
//import androidx.lifecycle.LiveData
//import com.example.englearn.data.database.entity.Article
//
//public  interface ArticleProtocol {
//    fun getArticleList(): LiveData<List<Article?>?>?
//
//    fun getArticleItem(position: Int): LiveData<Article?>?
//
//    fun addArticle()
//    fun deleteArticle(id: Int)
//    fun updateArticle(
//        number: Int,
//        artName: String?,
//        artText: String?,
//        isRead: Boolean?
//    )
//}