package com.example.dogbreedslist.data.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Breed(
    @Json(name = "name") var name: String? = "",
    @Json(name = "subbreeds") var subbreeds: List<String?> = listOf()
)