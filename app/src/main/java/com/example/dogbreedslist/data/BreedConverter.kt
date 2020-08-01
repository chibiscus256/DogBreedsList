package com.example.dogbreedslist.data

import androidx.room.TypeConverter
import java.util.stream.Collectors

class BreedConverter {
    @TypeConverter
    fun fromSubBreed(breedList: List<String>): String {
        return breedList.stream().collect(Collectors.joining(","))
    }

    @TypeConverter
    fun toSubBreed(data: String): List<String> {
        return listOf(data)
    }
}