package com.example.dogbreedslist.data.local.favorites

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoritesDao {
    @Query("SELECT * FROM Favorites")
    suspend fun getFavorites(): List<FavoriteData>

    @Query("SELECT * FROM Favorites WHERE name = :breed")
    suspend fun getPhotosOfBreed(breed: String): FavoriteData?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favorite: FavoriteData)

    @Query("DELETE FROM Favorites WHERE photo = :photo")
    suspend fun deleteFavorite(photo: String)
}
