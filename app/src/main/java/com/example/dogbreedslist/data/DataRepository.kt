package com.example.dogbreedslist.data

import com.example.dogbreedslist.data.local.LocalData
import com.example.dogbreedslist.data.network.RemoteData
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.data.network.dto.BreedsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DataRepository @Inject
constructor(internal val remoteData: RemoteData, val localData: LocalData) {

    suspend fun requestBreeds(): Flow<Resource<List<Breed>>> {
        return flow {
            emit(remoteData.requestBreeds())
        }
    }
}
