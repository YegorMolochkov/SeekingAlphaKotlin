package com.yegor.seekingalpha.seekingalpha

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Services factory
 */
fun createService(): SolarSystemServiceKotlin {

    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY

    val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

    val retrofit = Retrofit.Builder()
            .baseUrl("http://54.202.34.250:3000/page/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(okHttpClient)
            .build()


    return retrofit.create(SolarSystemServiceKotlin::class.java)
}