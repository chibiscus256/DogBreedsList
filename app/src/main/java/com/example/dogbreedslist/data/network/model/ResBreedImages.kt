package com.example.dogbreedslist.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResBreedImages(@Json(name = "message")
                       val images: ArrayList<String>?,
                          @Json(name = "status")
                       val status: String = "")