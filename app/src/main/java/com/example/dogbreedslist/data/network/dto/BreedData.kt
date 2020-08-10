package com.example.dogbreedslist.data.network.dto

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import java.util.*

@JsonClass(generateAdapter = true)
@Parcelize
data class BreedData(
    @Json(name = "name") var name: String = "",
    @Json(name = "subbreeds") var subbreeds: List<String>? = listOf()
) : Parcelable