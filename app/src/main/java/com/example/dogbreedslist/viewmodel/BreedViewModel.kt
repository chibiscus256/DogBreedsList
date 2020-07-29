package com.example.dogbreedslist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogbreedslist.data.network.RemoteData
import com.example.dogbreedslist.data.network.dto.Breed

class BreedViewModel(private val breedsRepository: RemoteData) : ViewModel(){
    private val _breedList = MutableLiveData<List<Breed>>()
    val breedList: LiveData<List<Breed>> = _breedList
}