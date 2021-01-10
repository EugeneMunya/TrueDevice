package com.example.truedevice.networkRetrofit

import retrofit2.Retrofit
import retrofit2.Retrofit.*
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        private const val BASE_URL="http//www.truedevice.rw/"
    }
    fun <Api> buildApi(
        api:Class<Api>
    ):Api{
        return Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}