package com.example.dogbreedslist.data.network.dto

import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class BreedsResponse(@SerializedName(value = "message") val breeds: JSONObject?)