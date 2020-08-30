package com.example.dogbreedslist.data

import com.example.dogbreedslist.data.local.LocalData
import com.example.dogbreedslist.data.local.favorites.FavoriteData
import com.example.dogbreedslist.data.network.RemoteData
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.data.network.dto.BreedImages
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DataRepository @Inject
constructor(private val remoteData: RemoteData, private val localData: LocalData) :
    DataRepositorySource {

    override suspend fun requestBreeds(): Flow<Resource<List<Breed>>> {
        return flow {
            emit(remoteData.requestBreeds())
        }
    }

    override suspend fun requestBreedImages(breed: String): Resource<List<String>> {
        return remoteData.requestBreedImages(breed)
    }

    override suspend fun requestSubbreedImages(
        breed: String,
        subbreed: String
    ): Resource<List<String>> {
        return remoteData.requestSubBreedImages(breed, subbreed)
    }

    override suspend fun addFavorite(favorite: FavoriteData) {
        return localData.addFavorite(favorite)
    }

    override suspend fun deleteFavorite(favorites: List<FavoriteData>) {
        TODO("Not yet implemented")
    }

    override suspend fun getPhotosOfBreed(breed: String): List<String> {
        return localData.getPhotosOfBreed(breed)
    }

    override suspend fun getFavoritesBreeds(): List<String> {
        return localData.getFavoritesBreeds()
    }
}