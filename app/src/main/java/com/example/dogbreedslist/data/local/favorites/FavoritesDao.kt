package com.example.dogbreedslist.data.local.favorites

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoritesDao {
    @Query("SELECT * FROM Favorites")
    suspend fun getFavorites(): List<FavoritesData>

    @Query("SELECT * FROM Favorites WHERE name = :breed")
    suspend fun getPhotosOfBreed(breed: String): FavoritesData?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(photo: FavoritesData)

    @Query("DELETE FROM Favorites WHERE photo = :photo")
    suspend fun deleteFavorite(photo: String)
}
