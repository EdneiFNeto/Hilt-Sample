package com.mvvm.project.retrofit.service

import com.mvvm.project.model.Person
import retrofit2.Call
import retrofit2.http.GET

interface TesteService {

    @GET("data.json")
    fun list(): Call<List<Person>>
}
