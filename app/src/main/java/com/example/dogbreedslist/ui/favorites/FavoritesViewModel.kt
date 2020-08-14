package com.example.dogbreedslist.ui.favorites

import android.widget.Toast
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogbreedslist.App
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.local.LocalData
import com.example.dogbreedslist.data.local.favorites.FavoritesData
import com.example.dogbreedslist.data.network.dto.BreedsResponse
import dagger.hilt.android.scopes.ActivityScoped

@ActivityScoped
class FavoritesViewModel @ViewModelInject constructor(favoritesRepository: LocalData) : ViewModel(){
    fun openItemDetails(favoriteItem: FavoritesData) {
        TODO("open detail view")
    }

    private val _favoritesList = MutableLiveData<List<FavoritesData>>()
    val breedsResponse: LiveData<List<FavoritesData>> = _favoritesList
}