package com.example.dogbreedslist.data.error


interface ErrorFactory {
    fun getError(errorCode: Int): Error
}