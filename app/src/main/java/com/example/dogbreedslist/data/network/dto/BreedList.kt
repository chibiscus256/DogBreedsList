package com.example.dogbreedslist.data.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BreedList(@Json(name = "message")
                  val message: List<Breed> = listOf())