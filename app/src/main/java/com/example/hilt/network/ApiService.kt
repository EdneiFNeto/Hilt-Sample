package com.example.hilt.network

import com.example.hilt.network.model.Images
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("image/random")
    fun getCountries(): Response<Images>
}
