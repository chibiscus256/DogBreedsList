package com.example.dogbreedslist.data.network.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "breeds")
data class Breed(
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "subbreeds") var description: List<String>? = null,
    @PrimaryKey @ColumnInfo(name = "entryid") var id: String = UUID.randomUUID().toString()
)