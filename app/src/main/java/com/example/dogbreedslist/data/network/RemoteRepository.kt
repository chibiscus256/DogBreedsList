package com.example.dogbreedslist.data.network

import androidx.lifecycle.LiveData
import com.example.dogbreedslist.App
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.network.dto.BreedList
import com.example.dogbreedslist.data.network.service.DogService
import com.example.dogbreedslist.data.Error.Companion.NETWORK_ERROR
import com.example.dogbreedslist.data.Error.Companion.NO_INTERNET_CONNECTION
import com.example.dogbreedslist.utils.Network.Utils.isConnected
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    private val serviceGenerator: ServiceGenerator
) : RemoteDataSource {

    override suspend fun requestBreeds(): LiveData<Resource<BreedList>> {
        val dogService = serviceGenerator.createService(DogService::class.java)
    }
}
