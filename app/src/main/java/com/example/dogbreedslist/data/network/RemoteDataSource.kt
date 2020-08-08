package com.example.dogbreedslist.data.network

import androidx.lifecycle.LiveData
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.network.dto.BreedList

internal interface RemoteDataSource{
    suspend fun requestBreeds(): Resource<BreedList>
}
