//package com.example.englearn.data.datasource
//
//import android.content.Context
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.example.englearn.data.database.ArticlesDataBase
//import com.example.englearn.data.database.dao.ArticlesDAO
//import com.example.englearn.data.database.entity.Article
//
//class ArticlesDataSource(private val context: Context, val db: ArticlesDataBase.Companion)
//{
//    var articles: List<Article> = ArrayList<Article>()
//
//    fun getArticle(position: Int): LiveData<Article> {
//        val db: ArticlesDataBase? = ArticlesDataBase.getDatabase(context)
//        val articlesDAO: ArticlesDAO? = db?.getArticlesDao()
//        val liveData: LiveData<Article> = MutableLiveData<Article>()
//        val articleLiveData: LiveData<Article>? = articlesDAO?.getArticle(position + 1)
//        return liveData
//    }
//
//}