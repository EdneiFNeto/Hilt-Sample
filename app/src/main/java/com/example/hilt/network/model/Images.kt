package com.example.hilt.network.model

import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: String
)
