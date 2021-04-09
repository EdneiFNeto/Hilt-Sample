package com.mvvm.project.retrofit

import android.content.Context
import com.mvvm.project.BuildConfig
import com.mvvm.project.retrofit.service.TesteService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = BuildConfig.URL_FAKE_API
class AppRetrofit(private val context: Context) {

    private val client by lazy {
        val interceptador = HttpLoggingInterceptor()
        interceptador.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .addInterceptor(interceptador)
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val testeService: TesteService by lazy{
        retrofit.create(TesteService::class.java)
    }
}
