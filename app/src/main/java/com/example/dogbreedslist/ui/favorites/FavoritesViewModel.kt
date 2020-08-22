package com.example.dogbreedslist.ui.favorites

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogbreedslist.data.local.LocalData
import com.example.dogbreedslist.data.local.favorites.FavoritesData
import dagger.hilt.android.scopes.ActivityScoped

@ActivityScoped
class FavoritesViewModel @ViewModelInject constructor(favoritesRepository: LocalData) : ViewModel(){

}