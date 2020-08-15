package com.example.dogbreedslist.data.network.jsonadapters

import android.util.ArrayMap
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.data.network.dto.BreedsResponse
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

/*class BreedsMoshiAdapter {
    @WrappedBreedList
    @FromJson
    fun fromJson (json: BreedsResponse) : ArrayMap<String, List<String>>? {
        return json.breeds
    }

    @ToJson
    fun toJson(@WrappedBreedList value: ArrayMap<String, List<String>>): BreedsResponse {
        throw UnsupportedOperationException()
    }
}*/
