package com.example.hilt.netiwork

import com.example.hilt.netiwork.model.Images
import retrofit2.Response
import retrofit2.http.GET

interface ExampleService {

    @GET("image/random")
    suspend fun all(): Response<Images>
}
