package com.example.dogbreedslist.ui.favorites.favoritesadapter

import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreedslist.databinding.ItemFavoriteBinding
import org.jetbrains.annotations.NotNull

class FavoriteViewHolder(val binding: ItemFavoriteBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: String) {
        binding.apply{
            setClickListener { toFavoritesPhotos() }
            breedName = item
            executePendingBindings()
        }
    }

    private fun toFavoritesPhotos() {
        TODO("Not yet implemented")
    }
}