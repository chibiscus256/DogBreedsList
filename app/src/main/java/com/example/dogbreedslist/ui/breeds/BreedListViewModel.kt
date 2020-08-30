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

// TODO: 26.08.2020 provide source instead of repo and understand how
class BreedListViewModel @ViewModelInject constructor(private val dataRepository: DataRepository) : ViewModel() {

    private val _breedList = MutableLiveData<Resource<List<Breed>>>()
    val breedsResponse: LiveData<Resource<List<Breed>>> = _breedList

    fun getBreeds() {
        viewModelScope.launch {
            _breedList.value = Resource.Loading()
            dataRepository.requestBreeds().collect{
                _breedList.value = it
            }
        }
    }
}