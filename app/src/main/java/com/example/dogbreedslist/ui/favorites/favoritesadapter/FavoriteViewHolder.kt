package com.example.dogbreedslist.ui.favorites.favoritesadapter

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreedslist.databinding.ItemFavoriteBinding
import com.example.dogbreedslist.ui.favorites.FavoritesListFragmentDirections
import com.example.dogbreedslist.viewmodel.FavoritesViewModel

class FavoriteViewHolder(val binding: ItemFavoriteBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: String, viewModel: FavoritesViewModel) {
        binding.apply {
            setClickListener { toFavoritesPhotos(it, item) }
            breedName = item
            //photosCount = viewModel.favoritesPhotos.value?.size!!
            executePendingBindings()
        }
    }

    private fun toFavoritesPhotos(view: View, breedName: String) {
        val direction = FavoritesListFragmentDirections.actionListToPhotos(
            fragmentFlag = true,
            breedName = breedName
        )
        view.findNavController().navigate(direction)
    }
}