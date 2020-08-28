package com.example.dogbreedslist.data

import com.example.dogbreedslist.data.local.favorites.FavoriteData
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.data.network.dto.BreedImages
import kotlinx.coroutines.flow.Flow

interface DataRepositorySource {
    suspend fun requestBreeds(): Flow<Resource<List<Breed>>>
    suspend fun requestBreedImages(breed: String): Resource<BreedImages>
    suspend fun requestSubbreedImages(breed: String, subbreed: String): Resource<BreedImages>
    suspend fun addFavorite(favorite: FavoriteData)
    suspend fun deleteFavorite(favorites: List<FavoriteData>)
    suspend fun getPhotosOfBreed(breed: String): List<String>
    suspend fun getFavoritesBreeds(): List<String>
}