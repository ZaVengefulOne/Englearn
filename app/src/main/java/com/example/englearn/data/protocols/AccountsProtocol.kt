package com.example.englearn.data.protocols

import com.example.englearn.data.models.LoginAdministrator
import com.example.englearn.data.models.LoginUser


interface AccountsProtocol {
    fun adminLogin(loginAdministrator: LoginAdministrator?): Boolean?
    fun userLogin(loginUser: LoginUser?): Boolean?
}