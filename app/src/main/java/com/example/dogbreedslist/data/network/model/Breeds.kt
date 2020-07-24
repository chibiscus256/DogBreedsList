package com.example.dogbreedslist.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Breeds(@Json(name = "message")
                  val message: List<String>?,
                  @Json(name = "status")
                  val status: String = "")