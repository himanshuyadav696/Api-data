package com.example.retrofit

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET

interface Apiinterface {
    @GET("users")
    fun getData(): Call<List<MyData.MyDataItem>>

}