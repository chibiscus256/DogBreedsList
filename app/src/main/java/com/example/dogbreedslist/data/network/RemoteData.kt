package com.example.dogbreedslist.data.network

import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.network.dto.BreedsResponse
import com.example.dogbreedslist.data.network.service.DogService
import com.example.dogbreedslist.data.Error.Companion.NETWORK_ERROR
import com.example.dogbreedslist.data.network.dto.Breed
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject constructor(
    private val dogService : DogService
) : RemoteDataSource {

    // TODO: 17.08.2020 refactor to human look
    override suspend fun requestBreeds(): Resource<List<Breed>> {
        return when (val response = processCall(dogService::getBreedList)) {
            is BreedsResponse -> {
                Resource.Success(response.breeds.flatMap { (breed, subBreeds) ->
                    subBreeds.ifEmpty { listOf(null) }
                        .map { subBreed ->
                            Breed(breed, subBreeds)
                        }
                })
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
/*        if (!isConnected(@ApplicationContext context: Context)) {
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
