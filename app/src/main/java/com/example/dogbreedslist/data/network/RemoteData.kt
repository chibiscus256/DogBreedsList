package com.example.dogbreedslist.data.network

import android.app.Application
import com.example.dogbreedslist.App
import com.example.dogbreedslist.data.Error.Companion.NETWORK_ERROR
import com.example.dogbreedslist.data.Error.Companion.NO_INTERNET_CONNECTION
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.data.network.dto.BreedImages
import com.example.dogbreedslist.data.network.dto.BreedsResponse
import com.example.dogbreedslist.data.network.service.DogService
import com.example.dogbreedslist.utils.Network.Utils.isConnected
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject constructor(
    private val dogService: DogService
) : RemoteDataSource {

    override suspend fun requestBreeds(): Resource<List<Breed>> {
        return when (val response = processCall(dogService::getBreedList)) {
            is BreedsResponse -> {
                Resource.Success(data = response.breeds.entries.map { (name, subs) ->
                    Breed(name, subs)
                })
            }
            else -> {
                Resource.DataError(errorCode = response.toString())
            }
        }
    }

    override suspend fun requestBreedImages(breed: String): Resource<List<String>> {
        return when (val response = processCall { (dogService::getBreedImages)(breed) }) {
            is BreedImages -> {
                Resource.Success(data = response.images)
            }
            else -> {
                Resource.DataError(errorCode = response.toString())
            }
        }
    }

    override suspend fun requestSubBreedImages(
        breed: String,
        subBreed: String
    ): Resource<List<String>> {
        return when (val response =
            processCall { (dogService::getSubBreedImages)(breed, subBreed) }) {
            is BreedImages -> {
                Resource.Success(data = response.images)
            }
            else -> {
                Resource.DataError(errorCode = response.toString())
            }
        }
    }

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
/*       if (!isConnected()) {
            return NO_INTERNET_CONNECTION
        }*/
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
