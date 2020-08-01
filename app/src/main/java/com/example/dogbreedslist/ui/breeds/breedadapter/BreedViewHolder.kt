package com.example.dogbreedslist.ui.breeds.breedadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.databinding.ItemBreedBinding
import com.example.dogbreedslist.ui.breeds.BreedListViewModel

class BreedViewHolder private constructor(val binding: ItemBreedBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(viewModel: BreedListViewModel, item: Breed) {

        binding.apply{
            binding.breedViewModel = viewModel
            breed = item
            executePendingBindings()
        }
    }

    companion object {
        fun from(parent: ViewGroup): BreedViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemBreedBinding.inflate(layoutInflater, parent, false)
            return BreedViewHolder(
                binding
            )
        }
    }
}