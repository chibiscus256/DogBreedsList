package com.example.dogbreedslist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.dogbreedslist.data.local.LocalData
import com.example.dogbreedslist.data.network.RemoteData
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.data.network.dto.BreedImages
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.processNextEventInCurrentThread
import java.lang.Exception
import javax.inject.Inject

class DataRepository @Inject
constructor(private val remoteData: RemoteData, val localData: LocalData) {

    suspend fun requestBreeds(): Flow<Resource<List<Breed>>> {
        return flow {
            emit(remoteData.requestBreeds())
        }
    }

    suspend fun requestBreedImages(breed: String): LiveData<Resource<BreedImages>> {
        return liveData(Dispatchers.IO) {
            emit(remoteData.requestBreedImages(breed))
        }
    }
}