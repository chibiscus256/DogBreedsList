package com.example.dogbreedslist.data.network

interface DataSource {
    fun requestBreeds(): Data?
}
