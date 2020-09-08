package com.example.dogbreedslist.data.local.favorites

import androidx.collection.ArrayMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoritesDao {
    @Query("SELECT name FROM Favorites")
    suspend fun getFavoritesNames(): Array<String>

    @Query("SELECT photo FROM Favorites WHERE name = :breed")
    suspend fun getPhotosOfBreed(breed: String): List<String>

    /*Проверяем, выставлять ли лайк*/
    @Query("SELECT EXISTS(SELECT * FROM favorites WHERE photo = :photo LIMIT 1)")
    suspend fun isLoved(photo: String): Boolean

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(favorite: FavoriteData)

    @Query("DELETE FROM favorites WHERE photo = :photo")
    suspend fun deleteFavorite(photo: String)

}
