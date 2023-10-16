package com.example.englearn.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.englearn.data.database.entity.Article

@Dao
interface ArticlesDAO {
    @get:Query("SELECT * FROM articles_table")
    val articles: List<Any?>?

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = Article::class)
    fun insertNewArticle(article: Article)

    @Query("SELECT * FROM articles_table WHERE :id LIKE id")
    fun getArticle(id: Int): Article

    @Query("SELECT * FROM articles_table")
    fun getArticles(): List<Article>

    @Query("DELETE FROM articles_table WHERE :id = id")
    fun deleteArticle(id: Int)
}
