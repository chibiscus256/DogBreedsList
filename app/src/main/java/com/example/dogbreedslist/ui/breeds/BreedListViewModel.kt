package com.example.dogbreedslist.ui.breeds

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogbreedslist.data.repository.DataRepository
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.network.dto.Breed
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BreedListViewModel @ViewModelInject constructor(private val dataRepository: DataRepository) :
    ViewModel() {

    private val _fetchedBreeds = MutableLiveData<Resource<List<Breed>>>()
    val breedsResponse: LiveData<Resource<List<Breed>>> = _fetchedBreeds

    fun getBreeds() {
        viewModelScope.launch {
            _fetchedBreeds.value = Resource.Loading()
            dataRepository.requestBreeds().collect {
                _fetchedBreeds.value = it
            }
        }
    }

}