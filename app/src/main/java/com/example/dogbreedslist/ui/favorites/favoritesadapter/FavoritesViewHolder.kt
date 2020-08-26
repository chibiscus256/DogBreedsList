package com.example.dogbreedslist.ui.favorites.favoritesadapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreedslist.data.local.favorites.FavoriteData
import com.example.dogbreedslist.databinding.ItemBreedBinding

class FavoritesViewHolder constructor(val binding: ItemBreedBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(breedItem: FavoriteData, recyclerItemListener: View.OnClickListener ) {
        binding.breedItem.text = breedItem.name
    }
}