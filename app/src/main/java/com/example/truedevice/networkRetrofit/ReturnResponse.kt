package com.example.truedevice.networkRetrofit

import okhttp3.ResponseBody

sealed class ReturnResponse<T> {
     data class SuccessResponse<T> (val value:T):ReturnResponse<T>()
     data class FailResponse(
             val isNetworkError:Boolean,
             val errorCode: Int?,
             val errorBody:ResponseBody?
    ):ReturnResponse<Nothing>()
}