package com.example.dogbreedslist.usecase


/*
class GettingBreedsUseCase @Inject constructor(
    private val dataRepository: DataSource,
    override val coroutineContext: CoroutineContext
) : CoroutineScope {

    fun getBreeds(callback: BaseCallback) {
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
*/
