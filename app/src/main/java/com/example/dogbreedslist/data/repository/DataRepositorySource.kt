package com.example.dogbreedslist.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.local.breeds.BreedData
import com.example.dogbreedslist.data.local.favorites.FavoriteData
import com.example.dogbreedslist.data.network.dto.Breed
import kotlinx.coroutines.flow.Flow

interface DataRepositorySource {
    suspend fun requestBreeds(): Flow<Resource<List<Breed>>>
    suspend fun requestBreedImages(breed: String): Resource<List<String>>
    suspend fun requestSubbreedImages(breed: String, subbreed: String): Resource<List<String>>
    suspend fun addFavorite(favorite: FavoriteData)
    suspend fun deleteFavorite(favorite: FavoriteData)
    suspend fun getPhotosOfBreedFromLocal(breed: String): List<String>
    suspend fun getFavoritesBreeds(): List<String>
    suspend fun getFavorites(): Array<String>
    suspend fun isLoved(url: String): Boolean
    suspend fun getBreedsWithLikes(): List<BreedData>
}