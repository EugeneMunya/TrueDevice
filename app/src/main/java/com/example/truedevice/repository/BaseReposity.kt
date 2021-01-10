package com.example.truedevice.repository

import com.example.truedevice.networkRetrofit.ReturnResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseReposity{
    suspend fun <T> safeApiCall(
            apiCall:suspend ()->T
    ): ReturnResponse<out T> {
        return withContext(Dispatchers.IO){
            try {
                ReturnResponse.SuccessResponse(apiCall.invoke())
            }catch (throwable: Throwable){
                when(throwable){
                    is HttpException->{
                        ReturnResponse.FailResponse(false,throwable.code(), throwable.response()?.errorBody())
                    }
                    else -> {
                        ReturnResponse.FailResponse(true,null,null)

                    }
                }
            }

        }

    }
}