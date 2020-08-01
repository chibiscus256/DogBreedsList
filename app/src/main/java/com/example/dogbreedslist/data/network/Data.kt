package com.example.dogbreedslist.data.network

import com.example.dogbreedslist.data.network.error.Error

class Data(var code: Int = 0, var error: Error? = null, var data: Any? = null) {

    constructor(errorCode: Int, dataObject: Any?) : this(errorCode, data = dataObject)

    constructor(errorObject: Error) : this(error = errorObject)

    constructor(dataObject: Any) : this(data = dataObject)
}