package com.example.dogbreedslist.data.local

import com.example.dogbreedslist.data.local.breeds.BreedDao
import com.example.dogbreedslist.data.local.breeds.BreedData
import com.example.dogbreedslist.data.local.favorites.FavoritesDao
import com.example.dogbreedslist.data.local.favorites.FavoriteData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalData @Inject constructor(
    private val favoritesDao: FavoritesDao,
    private val breedDao: BreedDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun addFavorite(favorite: FavoriteData) = withContext(ioDispatcher) {
        favoritesDao.insert(favorite)
        breedDao.insert(BreedData(name = favorite.name, likes = 0))
        breedDao.incrementLikes(favorite.name)
    }

    suspend fun deleteFavorite(favorite: FavoriteData) = withContext(ioDispatcher) {
        favoritesDao.deleteFavorite(favorite.photoUrl!!)
        breedDao.decrementLikes(favorite.name)
        breedDao.deleteFavorite()
    }

    suspend fun getBreedsAndLikes() = withContext(ioDispatcher){
        breedDao.getBreedsAndLikes()
    }

    suspend fun getFavorites() = withContext(ioDispatcher) {
        favoritesDao.getFavorites()
    }

    suspend fun getPhotosOfBreedFromLocal(breedName: String) = withContext(ioDispatcher) {
        favoritesDao.getPhotosOfBreed(breedName)
    }

    suspend fun getFavoritesBreeds() = withContext(ioDispatcher) {
        breedDao.getFavoritesBreeds()
    }
}