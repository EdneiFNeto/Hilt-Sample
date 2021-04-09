package com.mvvm.project.retrofit.service

import com.mvvm.project.model.Data
import com.mvvm.project.model.Teste
import retrofit2.Call
import retrofit2.http.GET

interface TesteService {

    @GET("persons?_quantity=10")
    fun list(): Call<Data>
}
