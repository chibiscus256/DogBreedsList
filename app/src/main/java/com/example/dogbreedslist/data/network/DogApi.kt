package com.example.dogbreedslist.data.network

import com.example.dogbreedslist.data.network.model.Breeds
import com.example.dogbreedslist.data.network.model.ResBreedImages
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApi {
    companion object {
        val ENDPOINT: String = "https://dog.ceo/api/"
    }

    @GET("breeds/list")
    fun getBreedList(): Response<Breeds>

    @GET("breed/{type}/images")
    fun getBreedImages(@Path("type") breedType: String): Response<ResBreedImages>
}
