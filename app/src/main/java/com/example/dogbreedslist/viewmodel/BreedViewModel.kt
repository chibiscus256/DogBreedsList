package com.example.dogbreedslist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogbreedslist.data.network.RemoteRepository
import com.example.dogbreedslist.data.network.dto.Breed
import javax.inject.Inject

class BreedViewModel @Inject constructor(private val breedsRepository: RemoteRepository) : ViewModel(){
    private val _breedList = MutableLiveData<List<Breed>>()
    val breedList: LiveData<List<Breed>> = _breedList
}