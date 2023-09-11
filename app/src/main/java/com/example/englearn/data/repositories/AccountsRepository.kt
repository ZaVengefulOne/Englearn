package com.example.englearn.data.repositories

import android.content.Context
import com.example.englearn.data.datasource.AccountsDataSource
import com.example.englearn.data.models.LoginAdministrator
import com.example.englearn.data.models.LoginUser
import com.example.englearn.data.protocols.AccountsProtocol



class AccountsRepository(private val context: Context) : AccountsProtocol {
    private val dataSource: AccountsDataSource

    init {
        dataSource = AccountsDataSource(context)
    }

    override fun adminLogin(loginAdministrator: LoginAdministrator?): Boolean? {
        return loginAdministrator?.let { dataSource.checkAdminUserValid(it) }
    }

    override fun userLogin(loginUser: LoginUser?): Boolean? {
        return loginUser?.let { dataSource.checkLoginUserValid(it) }
    }
}
