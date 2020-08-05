package com.example.dogbreedslist.usecase

import com.example.dogbreedslist.data.network.Data
import com.example.dogbreedslist.data.network.DataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.dogbreedslist.data.Error
import com.example.dogbreedslist.data.Error.Companion.INTERNAL_SERVER_ERROR
import com.example.dogbreedslist.data.network.dto.BreedList
import com.example.dogbreedslist.ui.base.BaseCallback
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class DblUseCase @Inject constructor(
    private val dataRepository: DataSource,
    override val coroutineContext: CoroutineContext
) : UseCase, CoroutineScope {

    override fun getBreeds(callback: BaseCallback) {
        launch {
            try {
                val serviceResponse: Data? =
                    withContext(Dispatchers.IO) { dataRepository.requestBreeds() }
                if (serviceResponse?.code == Error.SUCCESS_CODE) {
                    val data = serviceResponse.data
                    callback.onSuccess(data as BreedList)
                } else {
                    callback.onFail(serviceResponse?.error ?: Error(code = INTERNAL_SERVER_ERROR))
                }
            } catch (e: Exception) {
                callback.onFail(Error(e))
            }
        }
    }
}
