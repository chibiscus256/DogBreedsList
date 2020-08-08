package com.example.dogbreedslist.data

import com.example.dogbreedslist.data.network.dto.BreedList
import kotlinx.coroutines.flow.Flow

interface DataRepositorySource {
    suspend fun requestBreeds(): Flow<Resource<BreedList>>
}
