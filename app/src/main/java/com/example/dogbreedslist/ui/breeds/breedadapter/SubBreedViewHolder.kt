package com.example.dogbreedslist.ui.breeds.breedadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreedslist.databinding.ItemBreedBinding
import com.example.dogbreedslist.ui.breeds.BreedListViewModel

class SubBreedViewHolder private constructor(val binding: ItemBreedBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: BreedListViewModel, item: String) {

/*        binding.apply {
            binding.breedListViewModel = viewModel
            breed = item
            setClickListener { openSubbreeds(breed?.subbreeds.isNullOrEmpty()) }
            executePendingBindings()
        }*/
    }

    companion object {
        fun from(parent: ViewGroup): SubBreedViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemBreedBinding.inflate(layoutInflater, parent, false)
            return SubBreedViewHolder(binding)
        }
    }
}