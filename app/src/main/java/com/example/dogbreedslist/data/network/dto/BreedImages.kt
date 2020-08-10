package com.example.dogbreedslist.data.network.dto

import com.squareup.moshi.Json

data class BreedImages(@Json(name = "message")
                       val images: List<String>?)