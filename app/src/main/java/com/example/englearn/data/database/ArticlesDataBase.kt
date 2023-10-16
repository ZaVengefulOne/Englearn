//package com.example.englearn.data.database
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room.databaseBuilder
//import androidx.room.RoomDatabase
//import com.example.englearn.data.database.dao.ArticlesDAO
//import com.example.englearn.data.database.entity.Article
//
//
//@Database(entities = [Article::class], version = 1)
//abstract class ArticlesDataBase : RoomDatabase() {
//    abstract fun getArticlesDao(): ArticlesDAO
//
//    companion object {
//        @Volatile
//        private var INSTANCE: ArticlesDataBase? = null
//        fun getDatabase(context: Context): ArticlesDataBase? {
//            if (INSTANCE == null) {
//                synchronized(ArticlesDataBase::class.java) {
//                    if (INSTANCE == null) {
//                        INSTANCE = databaseBuilder(
//                            context.applicationContext,
//                            ArticlesDataBase::class.java, "articles_database"
//                        )
//                            .build()
//                    }
//                }
//            }
//            return INSTANCE
//        }
//    }
//}