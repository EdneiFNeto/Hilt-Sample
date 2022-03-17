package com.example.hilt.repository

import com.example.hilt.netiwork.ApiService

class Repository(private val apiService: ApiService) {
    fun getCountries() = apiService.getCountries()
}
