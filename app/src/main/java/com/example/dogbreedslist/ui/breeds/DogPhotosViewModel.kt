package com.example.dogbreedslist.ui.breeds

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogbreedslist.data.repository.DataRepository
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.local.favorites.FavoriteData
import kotlinx.coroutines.launch

class DogPhotosViewModel @ViewModelInject constructor(private val dataRepository: DataRepository) :
    ViewModel() {

    private val _photos = MutableLiveData<Resource<List<String>>>()
    val photos: LiveData<Resource<List<String>>> = _photos

    fun getPhotos(breed: String, subbreed: String) {
        viewModelScope.launch {
            if (subbreed == "no subbreeds") {
                _photos.postValue(dataRepository.requestBreedImages(breed))
            } else
                _photos.postValue(dataRepository.requestSubbreedImages(breed, subbreed))
        }
    }

    fun deleteFavorite(favorite: FavoriteData){
        viewModelScope.launch {
            dataRepository.deleteFavorite(favorite)
        }
    }

    fun addToFavorites(favorite: FavoriteData) {
        viewModelScope.launch {
            dataRepository.addFavorite(favorite)
        }
    }
}