package com.example.truedevice.repository

import com.example.truedevice.networkRetrofit.AuthAPICalls

class AuthRepository(
        private val apiInterface: AuthAPICalls
) :BaseReposity() {
   suspend fun login(email:String,password:String)=safeApiCall {
        apiInterface.login(email,password)
    }
}