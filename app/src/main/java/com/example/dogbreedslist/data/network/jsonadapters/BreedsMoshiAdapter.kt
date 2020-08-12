package com.example.dogbreedslist.data.network.jsonadapters

import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.data.network.dto.BreedsResponse
import com.squareup.moshi.FromJson


class BreedsMoshiAdapter {
    @FromJson
    fun fromJson (json: BreedsResponse) : List<Breed>?{
        return json.breeds
    }
}
