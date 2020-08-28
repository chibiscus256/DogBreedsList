package com.example.dogbreedslist.ui.favorites

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogbreedslist.data.DataRepository
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.launch

@ActivityScoped
class FavoritesViewModel @ViewModelInject constructor(private val favoritesRepository: DataRepository) :
    ViewModel() {

    private val _favoritesPhotos = MutableLiveData<List<String>>()
    val favoritesPhotos: LiveData<List<String>> = _favoritesPhotos

    private val _favoritesBreeds = MutableLiveData<List<String>>()
    val favoritesBreeds: LiveData<List<String>> = _favoritesBreeds

    fun fetchFavorites() {
        viewModelScope.launch {
            _favoritesPhotos.postValue(favoritesRepository.getFavoritesBreeds())
        }
    }

    fun fetchPhotos(breedName: String) {
        viewModelScope.launch {
            _favoritesBreeds.postValue(favoritesRepository.getPhotosOfBreed(breedName))
        }
    }
}