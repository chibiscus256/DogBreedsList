package com.example.dogbreedslist.ui.breeds

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogbreedslist.data.DataRepository
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.network.dto.BreedImages

class DogPhotosViewModel(val dataRepository: DataRepository) : ViewModel() {

    private val _photos = MutableLiveData<Resource<BreedImages>>()
    val photos: LiveData<Resource<BreedImages>> = _photos

    suspend fun getPhotos(breed: String): LiveData<Resource<BreedImages>> {
        return dataRepository.requestBreedImages(breed)
    }
}