package com.example.truedevice.networkRetrofit

import com.example.truedevice.responseMapper.AuthResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthAPICalls {
    @FormUrlEncoded
    @POST("auth/api/login")
  suspend fun login(@Field("email") email:String,
             @Field("password") password:String
    ):AuthResponse
    @FormUrlEncoded
    @POST("/auth/api/register")
   suspend fun registration(
        @Field("firstName") firstName:String,
        @Field("lastName") lastName:String,
        @Field("phoneNumber")phoneNumber:Number,
        @Field("email")email: String,
        @Field("nID")nID:Number
    ):AuthResponse
}