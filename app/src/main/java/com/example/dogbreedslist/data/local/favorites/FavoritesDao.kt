package com.example.dogbreedslist.data.local.favorites

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoritesDao {
    @Query("SELECT * FROM Favorites")
    suspend fun getFavorites(): List<FavoriteData>

    @Query("SELECT photo FROM Favorites WHERE name = :breed")
    suspend fun getPhotosOfBreed(breed: String): List<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favorite: FavoriteData)

    @Query("SELECT name FROM favorites")
    suspend fun getFavoritesNames(): List<String>

    @Query("DELETE FROM Favorites WHERE photo = :photo")
    suspend fun deleteFavorite(photo: String)

    @Query("SELECT DISTINCT name FROM FAVORITES")
    suspend fun getFavoritesBreeds(): List<String>
}
