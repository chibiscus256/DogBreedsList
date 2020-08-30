package com.example.dogbreedslist.ui.favorites

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogbreedslist.data.repository.DataRepository
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@ActivityScoped
class FavoritesViewModel @ViewModelInject constructor(private val favoritesRepository: DataRepository) :
    ViewModel() {

    private val _favoritesPhotos = MutableLiveData<List<String>>()
    val favoritesPhotos: LiveData<List<String>> = _favoritesPhotos

    private val _favoritesBreeds = MutableLiveData<List<String>>()
    val favoritesBreeds: LiveData<List<String>> = _favoritesBreeds

    private val _favoritesList = MutableLiveData<List<String>>()

    fun fetchFavoritesBreeds() {
        viewModelScope.launch {
            _favoritesBreeds.postValue(favoritesRepository.getFavoritesBreeds())
        }
    }

    fun fetchAllFavoritesNames() {
        viewModelScope.launch {
            val favoritesArray = favoritesRepository.getFavorites()
            val sorted =
                withContext(Dispatchers.Default) { favoritesArray.sortedWith(compareBy {it}) }
            _favoritesList.postValue(sorted)
        }
    }

    fun fetchPhotos(breedName: String) {
        viewModelScope.launch {
            _favoritesPhotos.postValue(favoritesRepository.getPhotosOfBreed(breedName))
        }
    }
}