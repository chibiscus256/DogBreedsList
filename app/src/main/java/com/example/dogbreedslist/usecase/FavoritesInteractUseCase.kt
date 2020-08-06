package com.example.dogbreedslist.usecase
import com.example.dogbreedslist.data.network.DataSource
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class FavoritesInteractUseCase @Inject constructor(
    private val dataRepository: DataSource,
    override val coroutineContext: CoroutineContext
) : CoroutineScope {
    fun addToFavorites() {

    }
}