package com.example.dogbreedslist.ui.favorites.favoritesadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreedslist.R
import com.example.dogbreedslist.data.local.favorites.FavoritesData
import com.example.dogbreedslist.databinding.ItemBreedBinding
import com.example.dogbreedslist.ui.favorites.FavoritesViewModel
import kotlinx.android.synthetic.main.item_breed.view.*

class FavoritesAdapter(
    private var favoritesViewModel: FavoritesViewModel,
    private var favorites: List<FavoritesData>
) : RecyclerView.Adapter<FavoritesViewHolder>() {

    private val onItemClickListener: View.OnClickListener =
        View.OnClickListener { TODO("Not yet implemented") }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val binding: ItemBreedBinding = DataBindingUtil
            .inflate(
                LayoutInflater.from(parent.context), R.layout.item_breed,
                parent, false
            )
        return FavoritesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return favorites.size
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.bind(favorites[position], onItemClickListener)
    }

}
