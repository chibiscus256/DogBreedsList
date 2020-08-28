package com.example.dogbreedslist.ui.breeds.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.dogbreedslist.ui.breeds.BreedListViewModel
import com.example.dogbreedslist.data.local.breeds.BreedData
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.ui.breeds.viewholders.BreedViewHolder

class BreedAdapter(
    private val breeds: List<Breed>
) : ListAdapter<BreedData, BreedViewHolder>((BreedDiffCallback())) {

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

class BreedDiffCallback : DiffUtil.ItemCallback<BreedData>() {
    override fun areItemsTheSame(oldItem: BreedData, newItem: BreedData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BreedData, newItem: BreedData): Boolean {
        return oldItem == newItem
    }
}
