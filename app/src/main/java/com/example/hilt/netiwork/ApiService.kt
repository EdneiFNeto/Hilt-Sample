package com.example.hilt.netiwork

import com.example.hilt.netiwork.model.Images
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Inject

interface ApiService {
    @GET("image/random")
    fun getCountries(): Response<Images>
}
