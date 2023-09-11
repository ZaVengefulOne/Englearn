package com.example.englearn.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.englearn.data.database.entity.Account


@Dao
interface AccountsDao {
    @get:Query("SELECT * FROM accounts_table")
    val accounts: LiveData<List<Any?>?>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(account: Account?)

    @Query("SELECT * FROM accounts_table WHERE :id LIKE id")
    fun getItem(id: Int): LiveData<Account?>?
}
