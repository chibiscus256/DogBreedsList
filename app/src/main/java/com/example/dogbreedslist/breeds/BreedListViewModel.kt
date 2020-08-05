package com.example.dogbreedslist.breeds

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogbreedslist.data.network.dto.BreedList
import com.example.dogbreedslist.ui.base.BaseCallback
import com.example.dogbreedslist.usecase.DblUseCase
import javax.inject.Inject
import com.example.dogbreedslist.data.Error

class BreedListViewModel @Inject constructor(dataUseCase: DblUseCase) : ViewModel() {

    var noInterNetConnection: MutableLiveData<Boolean> = MutableLiveData()
    var showError: MutableLiveData<Error> = MutableLiveData()
    private var breedsUseCase: DblUseCase = dataUseCase

    private val _breedList = MutableLiveData<BreedList>()
    val breedList: LiveData<BreedList> = _breedList

    fun getBreeds() {
        breedsUseCase.getBreeds(callback)
    }

    private val callback = object : BaseCallback {

        override fun onSuccess(data: Any) {
            _breedList.postValue(data as BreedList)
        }

        override fun onFail(error: Error) {
            if (error.code == Error.NO_INTERNET_CONNECTION) {
                noInterNetConnection.postValue(true)
            } else {
                showError.postValue(error)
            }

        }
    }
}