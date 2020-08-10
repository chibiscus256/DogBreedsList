package com.example.dogbreedslist.data.local.breeds

import androidx.room.Dao
import androidx.room.Query
import com.example.dogbreedslist.data.network.dto.BreedData

@Dao
interface BreedDao{
    @Query("SELECT * FROM breeds")
    suspend fun getBreeds(): List<BreedData>
     
}