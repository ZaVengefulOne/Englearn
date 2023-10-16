package com.example.englearn.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles_table")
data class Article(val number: Int, val artName: String, val artText: String, val isRead: Boolean) {
    @PrimaryKey
    @ColumnInfo(name = "id")
    var uid: Int? = null

}