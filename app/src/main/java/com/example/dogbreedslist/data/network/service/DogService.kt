package com.example.dogbreedslist.data.network.service

import com.example.dogbreedslist.data.network.dto.ApiResponse
import com.example.dogbreedslist.data.network.dto.BreedImages
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogService {
    companion object {
        val ENDPOINT: String = "https://dog.ceo/api/"
    }

    @GET("breeds/list/all")
    suspend fun getBreedList(): Response<ApiResponse>

    @GET("breed/{type}/{subtype}/images")
    suspend fun getSubBreedImages(
        @Path("type") type: String,
        @Path("subtype") subtype: String
    ): Response<BreedImages>

    @GET("breed/{type}/images")
    suspend fun getBreedImages(@Path("type") breedType: String): Response<BreedImages>
}
