package com.example.dogbreedslist.data.network

import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.data.network.dto.BreedImages
import com.example.dogbreedslist.data.network.dto.BreedsResponse

internal interface RemoteDataSource {
    suspend fun requestBreeds(): Resource<List<Breed>>
    suspend fun requestBreedImages(breed: String): Resource<BreedImages>
    suspend fun requestSubBreedImages(breed: String, subBreed: String): Resource<BreedImages>
}
