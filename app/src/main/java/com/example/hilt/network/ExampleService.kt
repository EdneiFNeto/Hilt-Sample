package com.example.hilt.network

import com.example.hilt.network.model.Images
import retrofit2.Response
import retrofit2.http.GET

interface ExampleService {

    @GET("image/random")
    suspend fun all(): Response<Images>
}
