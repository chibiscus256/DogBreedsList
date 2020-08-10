package com.example.dogbreedslist.data.local.favorites

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface FavoritesDao {
    @Query("SELECT * FROM favorites")
    suspend fun getFavorites(): List<String>

    @Query("SELECT * FROM favorites WHERE name = :breed")
    suspend fun getPhotosOfBreed(breed: String): List<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(photo: FavoritesData)

    @Query("DELETE FROM favorites WHERE photo = :photo")
    suspend fun deleteFavorite(photo: FavoritesData)
}
