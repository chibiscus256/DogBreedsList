package com.example.dogbreedslist.data.network.error


interface ErrorFactory {
    fun getError(errorCode: Int): Error
}