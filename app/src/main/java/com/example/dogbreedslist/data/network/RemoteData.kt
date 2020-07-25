package com.example.dogbreedslist.data.network

import com.example.dogbreedslist.App
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.network.dto.Breeds
import com.example.dogbreedslist.data.network.service.DogService
import com.example.dogbreedslist.data.error.Error.Companion.NETWORK_ERROR
import com.example.dogbreedslist.data.error.Error.Companion.NO_INTERNET_CONNECTION
import com.example.dogbreedslist.utils.Network.Utils.isConnected
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject
constructor(private val serviceGenerator: ServiceGenerator) : RemoteDataSource {

    override suspend fun requestBreeds(): Resource<Breeds> {
        val dogService = serviceGenerator.createService(DogService::class.java)
        return when (val response = processCall(dogService::getBreedList)) {
            is Breeds -> {
                Resource.Success(data = response)
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        if (!isConnected(App.context)) {
            return NO_INTERNET_CONNECTION
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
            NETWORK_ERROR
        }
    }
}
