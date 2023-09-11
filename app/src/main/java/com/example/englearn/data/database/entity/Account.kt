package com.example.englearn.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts_table")
class Account(val login: String, val password: String, val isAdmin: Boolean) {
    @PrimaryKey
    @ColumnInfo(name = "id")
    var uid: Int? = null

}