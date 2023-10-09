package com.example.englearn.data.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.englearn.data.database.entity.Article
import com.example.englearn.data.datasource.ArticlesDataSource
import com.example.englearn.data.protocols.ArticleProtocol

class ArticleRepository(context: Context, dataSource: ArticlesDataSource) {
    private var dataSource: ArticlesDataSource? = null
// TODO: Доделать бдшку
//    fun getArticlesList(): LiveData<List<Appointment?>?>? {
//        return dataSource.getAppointments()
//    }
//
//    fun getAppointmentItem(id: Int): LiveData<Appointment?>? {
//        return dataSource.getAppointmentItem(id)
//    }
//
//    fun addAppointment() {
//        dataSource.addAppointment()
//    }
//
//    fun deleteAppointment(id: Int) {
//        dataSource.deleteAppointment(id)
//    }
//
//    fun updateAppointment(
//        id: Int,
//        doctorName: String?,
//        doctorSpec: String?,
//        patientName: String?,
//        patientDiagnosis: String?
//    ) {
//        dataSource.updateAppointment(id, doctorName, doctorSpec, patientName, patientDiagnosis)
//    }
//
//    override fun getArticleList(): LiveData<List<Article?>?>? {
//        return dataSource.getArticle()
//    }
//
//    override fun getArticleItem(position: Int): LiveData<Article?>? {
//        TODO("Not yet implemented")
//    }
//
//    override fun addArticle() {
//        TODO("Not yet implemented")
//    }
//
//    override fun deleteArticle(id: Int) {
//        TODO("Not yet implemented")
//    }
//
//    override fun updateArticle(number: Int, artName: String?, artText: String?, isRead: Boolean?) {
//        TODO("Not yet implemented")
//    }

}