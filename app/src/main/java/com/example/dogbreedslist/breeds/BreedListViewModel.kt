package com.example.dogbreedslist.breeds

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogbreedslist.data.DataRepositorySource
import com.example.dogbreedslist.data.network.dto.BreedList
import com.example.dogbreedslist.ui.base.BaseCallback
import javax.inject.Inject
import com.example.dogbreedslist.data.Error
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.network.RemoteData
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BreedListViewModel @ViewModelInject constructor(private val dataRepository: DataRepositorySource) : ViewModel() {

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