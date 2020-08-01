package com.example.dogbreedslist.usecase

import com.example.dogbreedslist.ui.base.BaseCallback

interface UseCase {
    fun getBreeds(callback: BaseCallback)
}
