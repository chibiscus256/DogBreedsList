package com.example.dogbreedslist.data.source.local

import androidx.room.Dao
import androidx.room.Query
import com.example.dogbreedslist.data.network.dto.Breed

@Dao
public interface BreedDao{
    @Query("SELECT * FROM breeds")
    suspend fun getBreeds(): List<Breed>
}