package com.example.dogbreedslist.ui.breeds.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.dogbreedslist.data.local.breeds.BreedData
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.ui.breeds.viewholders.BreedViewHolder

class BreedAdapter(
    private val breeds: List<Breed>
) : ListAdapter<Breed, BreedViewHolder>((BreedDiffCallback())) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        return BreedViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return breeds.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(viewHolderBreed: BreedViewHolder, position: Int) {
        viewHolderBreed.bind(breeds[position])
    }
}

class BreedDiffCallback : DiffUtil.ItemCallback<Breed>() {
    override fun areItemsTheSame(oldItem: Breed, newItem: Breed): Boolean {
        return (oldItem.subbreeds == newItem.subbreeds) && (oldItem.name == newItem.name)
    }

    override fun areContentsTheSame(oldItem: Breed, newItem: Breed): Boolean {
        return oldItem == newItem
    }
}
