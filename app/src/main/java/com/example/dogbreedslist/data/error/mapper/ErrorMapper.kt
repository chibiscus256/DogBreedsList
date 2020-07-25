package com.example.dogbreedslist.data.error.mapper

import com.example.dogbreedslist.App
import com.example.dogbreedslist.R
import com.example.dogbreedslist.data.error.Error
import javax.inject.Inject

class ErrorMapper @Inject constructor() : ErrorMapperInterface {

    override fun getErrorString(errorId: Int): String {
        return App.context.getString(errorId)
    }

    override val errorsMap: Map<Int, String>
        get() = mapOf(
                Pair(Error.NO_INTERNET_CONNECTION, getErrorString(R.string.no_internet)),
                Pair(Error.NETWORK_ERROR, getErrorString(R.string.network_error))
        ).withDefault { getErrorString(R.string.network_error) }
}