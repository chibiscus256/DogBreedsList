package com.example.dogbreedslist.ui.favorites

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.dogbreedslist.data.local.LocalData
import dagger.hilt.android.scopes.ActivityScoped

@ActivityScoped
class FavoritesViewModel @ViewModelInject constructor(favoritesRepository: LocalData) : ViewModel(){
}