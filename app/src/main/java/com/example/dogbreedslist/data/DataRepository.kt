package com.example.dogbreedslist.data

import com.example.dogbreedslist.data.local.LocalData
import com.example.dogbreedslist.data.network.RemoteData
import com.example.dogbreedslist.data.network.dto.BreedsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DataRepository @Inject
constructor(internal val remoteData: RemoteData, val localData: LocalData) {

    suspend fun requestBreeds(): Flow<Resource<BreedsResponse>> {
        return flow {
            emit(remoteData.requestBreeds())
        }.flowOn(Dispatchers.IO)
    }
}
