package com.example.dogbreedslist.data.network

import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.network.dto.Breeds

internal interface RemoteDataSource {
    suspend fun requestBreeds(): Resource<Breeds>
}
