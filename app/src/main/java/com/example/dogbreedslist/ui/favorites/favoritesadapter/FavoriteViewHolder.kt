package com.example.dogbreedslist.ui.favorites.favoritesadapter

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreedslist.data.local.breeds.BreedData
import com.example.dogbreedslist.databinding.ItemFavoriteBinding
import com.example.dogbreedslist.ui.favorites.FavoritesListFragmentDirections
import com.example.dogbreedslist.ui.favorites.FavoritesViewModel

class FavoriteViewHolder(val binding: ItemFavoriteBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: BreedData, viewModel: FavoritesViewModel) {
        binding.apply {
            setClickListener { toFavoritesPhotos(it, item) }
            breedName = item.name
            breedData = item
            executePendingBindings()
        }
    }

    private fun toFavoritesPhotos(view: View, breed: BreedData) {
        val direction = FavoritesListFragmentDirections.actionListToPhotos(
            fragmentFlag = true,
            breedName = breed.name
        )
        view.findNavController().navigate(direction)
    }
}