package com.example.dogbreedslist.data.local.breeds

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/*
Завел табличку под лайки, потому что, наверное, очень затратно для каждой ячейки списка считать,
сколько фотографий определенной породы у нас есть.
*/
@Entity(tableName = "breeds")
data class BreedData @JvmOverloads constructor(
    @PrimaryKey @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "likes") var likes: Int = 0
)