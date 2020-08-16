package com.example.dogbreedslist.data.network.dto

import com.squareup.moshi.Json

data class BreedsResponse(@Json(name = "message") val breeds: Map<String, List<String>>)