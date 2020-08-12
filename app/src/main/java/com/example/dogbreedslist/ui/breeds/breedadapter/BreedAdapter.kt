package com.example.dogbreedslist.ui.breeds.breedadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.ui.breeds.BreedListViewModel
import com.example.dogbreedslist.data.local.breeds.BreedData

class BreedAdapter(private val viewModel: BreedListViewModel, private val breeds: List<Breed>) :
    ListAdapter<BreedData, BreedViewHolder>((BreedDiffCallback())) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        return BreedViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return breeds.size
    }

    override fun onBindViewHolder(holderBreed: BreedViewHolder, position: Int) {
        holderBreed.bind(viewModel, breeds[position])
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
