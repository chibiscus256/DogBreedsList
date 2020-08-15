package com.example.dogbreedslist.ui.breeds.breedadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreedslist.data.local.breeds.BreedData
import com.example.dogbreedslist.databinding.ItemBreedBinding
import com.example.dogbreedslist.ui.breeds.BreedListViewModel

class BreedViewHolder private constructor(val binding: ItemBreedBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(viewModel: BreedListViewModel, item: BreedData) {

        binding.apply{
            binding.breedListViewModel = viewModel
            breed = item
            executePendingBindings()
        }
    }

    companion object {
        fun from(parent: ViewGroup): BreedViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemBreedBinding.inflate(layoutInflater, parent, false)
            return BreedViewHolder(binding)
        }
    }
}