package com.yasmin.solace_application.api

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.yasmin.solace_application.ViewModel.SolaceApplication
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
  val client = OkHttpClient.Builder()
     .addInterceptor((ChuckerInterceptor(SolaceApplication.appContext)))
      .build()
    var retrofit = Retrofit.Builder()
        .baseUrl("https://solaceeapp.herokuapp.com/api/")

        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun <T> buildApiClient(apiInterface: Class<T>): T {
        return retrofit.create(apiInterface)
    }
}