package com.example.dogbreedslist.ui.breeds

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogbreedslist.data.DataRepository
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.network.dto.BreedList
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect


class BreedListViewModel @ViewModelInject constructor(private val dataRepository: DataRepository) : ViewModel() {

    private val _breedList = MutableLiveData<Resource<BreedList>>()
    val breedList: LiveData<Resource<BreedList>> = _breedList

    fun getBreeds() {
        viewModelScope.launch {
            _breedList.value = Resource.Loading()
            dataRepository.requestBreeds().collect {
                _breedList.value = it
            }
        }
    }
}