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

    fun openItemDetails(favoriteItem: FavoritesData) {
        TODO("open detail view")
    }

    private val _favoritesList = MutableLiveData<List<FavoritesData>>()
    val favoritesList: LiveData<List<FavoritesData>> = _favoritesList
    val data1 = FavoritesData("aedsczxv", "easfgvdc")
    val data2 = FavoritesData("11111", "easwdadsfgvdc")
    val data3 = FavoritesData("vvvvvvvv", "sfrgbfrgvvvvvdc")

    fun prepareItems() {
        if (_favoritesList.value == null) {
            val list = mutableListOf<FavoritesData>()
            repeat(20) {
                list.add(data1)
                list.add(data2)
                list.add(data3)
            }
            _favoritesList.postValue(list)
        } else _favoritesList.postValue(_favoritesList.value)
    }

}