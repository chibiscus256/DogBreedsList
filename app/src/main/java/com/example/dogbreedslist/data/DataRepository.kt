package com.example.dogbreedslist.data

import com.example.dogbreedslist.data.local.LocalData
import com.example.dogbreedslist.data.network.RemoteData
import com.example.dogbreedslist.data.network.dto.BreedList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


/**
 * Created by AhmedEltaher
 */

class DataRepository @Inject
constructor(internal val remoteData: RemoteData, localData: LocalData) : DataRepositorySource {

    override suspend fun requestBreeds(): Flow<Resource<BreedList>> {
        return flow {
            emit(remoteData.requestBreeds())
        }.flowOn(Dispatchers.IO)
    }
}
