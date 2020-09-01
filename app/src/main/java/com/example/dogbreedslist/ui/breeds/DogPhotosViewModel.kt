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

    /*Я не знаю, на что подписывать поле со списком лайкнутых фото, поэтому тяну его так
    * без LiveData */
    private var _storedPhotos : MutableList<String>? = mutableListOf()
    val storedPhotos: List<String>? = _storedPhotos

    fun fetchPhotos(breed: String, subbreed: String) {
        viewModelScope.launch {
            if (subbreed == "no subbreeds") {
                _photos.postValue(dataRepository.requestBreedImages(breed))
                _storedPhotos = dataRepository.getPhotosOfBreedFromLocal(breed) as MutableList<String>
            } else {
                _photos.postValue(dataRepository.requestSubbreedImages(breed, subbreed))
                _storedPhotos = dataRepository.getPhotosOfBreedFromLocal(subbreed) as MutableList<String>
            }
        }
    }

    fun deleteFavorite(favorite: FavoriteData) {
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