package com.example.dogbreedslist.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dogbreedslist.data.BreedConverter
import com.example.dogbreedslist.data.local.breeds.BreedDao
import com.example.dogbreedslist.data.local.breeds.BreedData
import com.example.dogbreedslist.data.local.favorites.FavoritesDao
import com.example.dogbreedslist.data.local.favorites.FavoritesData

/**
 * The Room database for this app
 */
@Database(entities = [BreedData::class, FavoritesData::class],
        version = 1, exportSchema = false)
@TypeConverters(BreedConverter::class)
abstract class BreedsDatabase : RoomDatabase() {

    abstract fun breedDao(): BreedDao
    abstract fun favoritesDao(): FavoritesDao
    
    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: BreedsDatabase? = null

        fun getInstance(context: Context): BreedsDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): BreedsDatabase {
            return Room.databaseBuilder(context, BreedsDatabase::class.java, "dogbreeds-db")
                    .build()
        }
    }
}
