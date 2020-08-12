package com.example.dogbreedslist.data.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BreedsResponse(@Json(name = "message") val breeds: List<Breed>? = listOf())