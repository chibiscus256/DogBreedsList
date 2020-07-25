package com.example.dogbreedslist.data.network.dto

import com.squareup.moshi.Json

data class Breeds(@Json(name = "message")
                  val message: List<String>?,
                  @Json(name = "status")
                  val status: String = "")