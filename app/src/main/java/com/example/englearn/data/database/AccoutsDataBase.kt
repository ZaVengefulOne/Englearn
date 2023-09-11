package com.example.englearn.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.englearn.data.database.dao.AccountsDao
import com.example.englearn.data.database.entity.Account


@Database(entities = [Account::class], version = 1, exportSchema = false)
abstract class AccountsDataBase : RoomDatabase() {
    abstract fun accountsDao(): AccountsDao?

    companion object {
        @Volatile
        private var INSTANCE: AccountsDataBase? = null
        fun getDatabase(context: Context): AccountsDataBase? {
            if (INSTANCE == null) {
                synchronized(AccountsDataBase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = databaseBuilder(
                            context.applicationContext,
                            AccountsDataBase::class.java, "accounts_database"
                        )
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}