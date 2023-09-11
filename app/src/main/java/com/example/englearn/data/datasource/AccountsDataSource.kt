package com.example.englearn.data.datasource

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.englearn.data.database.AccountsDataBase
import com.example.englearn.data.database.dao.AccountsDao
import com.example.englearn.data.database.entity.Account
import com.example.englearn.data.models.LoginAdministrator
import com.example.englearn.data.models.LoginUser



class AccountsDataSource(private val context: Context) {
//    private val workManager: WorkManager
    var accounts: List<Account> = ArrayList<Account>()

//    init {
//        workManager = WorkManager.getInstance(context)
//    }

//    private fun createInputData(login: String): Data {
//        val Databuilder: Data.Builder = Builder()
//        Databuilder.putString(UserDataWorker.KEY_LOG, login)
//        return Databuilder.build()
//    }

    fun checkLoginUserValid(loginUser: LoginUser): Boolean {
//        val workRequest: OneTimeWorkRequest = Builder(UserDataWorker::class.java)
//            .setInputData(createInputData(loginUser.getLogin())).build()
//        workManager.enqueue(workRequest)
        return loginUser.login.equals("Vengeful") &&
                loginUser.password.equals("123456") || loginUser.login
            .equals("Nakarat") && loginUser.password.equals("Tarakan") || loginUser.login
            .equals("Korpalo1337") && loginUser.password.equals("ilovearabic")
    }

    fun checkAdminUserValid(loginAdministrator: LoginAdministrator): Boolean {
        return loginAdministrator.admlogin.equals("admin") &&
                loginAdministrator.passkey.equals("admin")
    }

    fun getAccount(position: Int): LiveData<Account> {
        val db: AccountsDataBase? = AccountsDataBase.getDatabase(context)
        val accountsDao: AccountsDao? = db?.accountsDao()
        val liveData: MutableLiveData<Account> = MutableLiveData<Account>()
        val doctorLiveData: LiveData<Account?>? = accountsDao?.getItem(position + 1)
        return liveData
    }
}