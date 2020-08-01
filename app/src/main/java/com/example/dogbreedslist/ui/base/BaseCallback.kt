package com.example.dogbreedslist.ui.base

import com.example.dogbreedslist.data.Error

interface BaseCallback {
    fun onSuccess(data: Any)

    fun onFail(error : Error)
}