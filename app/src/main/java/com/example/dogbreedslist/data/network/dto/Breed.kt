package com.example.dogbreedslist.data.network.dto

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Breed(
    @Json(name = "name") var name: String = "",
    @Json(name = "subbreeds") var subbreeds: List<String>? = listOf()
) : Parcelable