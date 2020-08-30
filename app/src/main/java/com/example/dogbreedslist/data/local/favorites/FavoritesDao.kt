package com.example.dogbreedslist.data.local.favorites

import androidx.collection.ArrayMap
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoritesDao {
    @Query("SELECT name FROM Favorites")
    suspend fun getFavorites(): Array<String>

    @Query("SELECT photo FROM Favorites WHERE name = :breed")
    suspend fun getPhotosOfBreed(breed: String): List<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favorite: FavoriteData)

    @Query("DELETE FROM favorites WHERE photo = :photo")
    suspend fun deleteFavorite(photo: String)

}
