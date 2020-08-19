package com.example.dogbreedslist.ui.breeds

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.dogbreedslist.data.network.dto.Breed

class BreedViewModel @ViewModelInject constructor(breed: Breed) : ViewModel(){
    var breedName = breed.name
}