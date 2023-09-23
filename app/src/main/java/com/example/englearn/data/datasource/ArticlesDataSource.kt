package com.example.englearn.data.datasource

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.englearn.data.database.AccountsDataBase
import com.example.englearn.data.database.ArticlesDataBase
import com.example.englearn.data.database.dao.AccountsDao
import com.example.englearn.data.database.dao.ArticlesDAO
import com.example.englearn.data.database.entity.Account
import com.example.englearn.data.database.entity.Article

class ArticlesDataSource(private val context: Context)
{
    var articles: List<Article> = ArrayList<Article>()

    fun getArticle(position: Int): LiveData<Article> {
        val db: ArticlesDataBase? = ArticlesDataBase.getDatabase(context)
        val articlesDAO: ArticlesDAO? = db?.articlesDao()
        val liveData: MutableLiveData<Article> = MutableLiveData<Article>()
        val articleLiveData: LiveData<Article?>? = articlesDAO?.getItem(position + 1)
        return liveData
    }

}