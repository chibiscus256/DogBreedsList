package com.example.dogbreedslist.ui.breeds

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogbreedslist.data.DataRepository
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.network.dto.BreedImages
import kotlinx.coroutines.launch

class DogPhotosViewModel @ViewModelInject constructor(val dataRepository: DataRepository) :
    ViewModel() {

    private val _photos = MutableLiveData<Resource<BreedImages>>()
    val photos: LiveData<Resource<BreedImages>> = _photos

    fun getPhotos(breed: String, subbreed: String) {
        viewModelScope.launch {
            if (subbreed == "no subbreeds") {
                _photos.postValue(dataRepository.requestBreedImages(breed))
            } else
                _photos.postValue(dataRepository.requestSubbreedImages(breed, subbreed))
        }
    }
}