package com.example.dogbreedslist.data.network.service

import com.example.dogbreedslist.data.network.dto.BreedList
import com.example.dogbreedslist.data.network.dto.ResBreedImages
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogService {
    companion object {
        val ENDPOINT: String = "https://dog.ceo/api/"
    }

    @GET("breeds/list")
    suspend fun getBreedList(): Response<BreedList>

    @GET("breed/{type}/images")
    suspend fun getBreedImages(@Path("type") breedType: String): Response<ResBreedImages>
}
