package com.example.dogbreedslist.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dogbreedslist.data.utils.BreedConverter
import com.example.dogbreedslist.data.network.dto.Breed

/**
 * The Room database for this app
 */
@Database(entities = [Breed::class],
        version = 1, exportSchema = false)
@TypeConverters(BreedConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun breedDao(): BreedDao

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "dogbreeds-db")
                    .addCallback(object : RoomDatabase.Callback() {
                    })
                    .build()
        }
    }
}
