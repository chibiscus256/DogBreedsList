package com.example.dogbreedslist.data.network.jsonadapters

import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.data.network.dto.BreedsResponse
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson


/*class BreedsMoshiAdapter {
    @WrappedBreedList
    @FromJson
    fun fromJson (json: BreedsResponse) : List<Breed>? {
        return json.breeds
    }

    @ToJson
    fun toJson(@WrappedBreedList value: List<Breed>): BreedsResponse {
        throw UnsupportedOperationException()
    }
}*/
