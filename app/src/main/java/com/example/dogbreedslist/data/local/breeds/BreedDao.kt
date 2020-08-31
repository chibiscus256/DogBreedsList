package com.example.dogbreedslist.data.local.breeds

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BreedDao{
    @Query("SELECT name FROM breeds")
    suspend fun getFavoritesBreeds(): List<String>

    @Query("SELECT * FROM breeds")
    suspend fun getBreedsAndLikes(): List<BreedData>

    @Query("UPDATE breeds SET likes = likes + 1 WHERE name = :name")
    suspend fun incrementLikes(name: String)

    @Query("UPDATE breeds SET likes = likes - 1 WHERE name = :name")
    suspend fun decrementLikes(name: String)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(breed: BreedData)

    //Это я не нашел, как удалить запись, если у нее лайков меньше 0
    @Query("DELETE FROM breeds WHERE likes = 0")
    suspend fun deleteFavorite()
}