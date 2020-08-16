package com.example.dogbreedslist.ui.breeds

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogbreedslist.data.DataRepository
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.local.breeds.BreedData
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.data.network.dto.BreedsResponse
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect


class BreedListViewModel @ViewModelInject constructor(private val dataRepository: DataRepository) : ViewModel() {

    private val _breedList = MutableLiveData<Resource<List<Breed>>>()
    val breedsResponse: LiveData<Resource<List<Breed>>> = _breedList

    fun getBreeds() {
        viewModelScope.launch {
            _breedList.value = Resource.Loading()
            dataRepository.requestBreeds().collect {
                _breedList.value = it
            }
        }
    }
}