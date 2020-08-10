package com.example.dogbreedslist.data.network.dto

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
@Entity(tableName = "breeds")
data class Breed(
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "subbreeds") var subbreeds: List<String>? = null,
    @PrimaryKey @ColumnInfo(name = "entryid") var id: String = UUID.randomUUID().toString()
)