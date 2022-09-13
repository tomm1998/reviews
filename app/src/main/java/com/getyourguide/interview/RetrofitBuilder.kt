package com.getyourguide.interview

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitBuilder {

  fun <T> build(apiInterface: Class<T>): T =
    Retrofit.Builder()
      .addConverterFactory(MoshiConverterFactory.create())
      .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(Level.BODY)).build())
      .baseUrl("https://travelers-api.getyourguide.com/")
      .build()
      .create(apiInterface)
}
