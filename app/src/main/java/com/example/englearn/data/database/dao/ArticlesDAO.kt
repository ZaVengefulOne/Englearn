package com.example.englearn.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.englearn.data.database.entity.Account
import com.example.englearn.data.database.entity.Article

@Dao
interface ArticlesDAO {
    @get:Query("SELECT * FROM articles_table")
    val articles: LiveData<List<Any?>?>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(article: Article)

    @Query("SELECT * FROM articles_table WHERE :id LIKE id")
    fun getItem(id: Int): LiveData<Article?>?
}
