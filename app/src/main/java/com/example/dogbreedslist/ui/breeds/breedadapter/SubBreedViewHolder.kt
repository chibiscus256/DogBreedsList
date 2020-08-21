package com.example.dogbreedslist.ui.breeds.breedadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.databinding.ItemBreedBinding
import com.example.dogbreedslist.ui.breeds.BreedListFragmentDirections
import com.example.dogbreedslist.ui.breeds.BreedListViewModel
import com.example.dogbreedslist.ui.breeds.SubbreedsListFragmentDirections

class SubBreedViewHolder private constructor(val binding: ItemBreedBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(viewModel: BreedListViewModel, item: String) {

        binding.apply {
            binding.breedListViewModel = viewModel
            subbreed = item
            setClickListener { openDogsPhotos(item, it) }
            executePendingBindings()
        }
    }

    fun openDogsPhotos(subbreed: String, view: View) {
        val direction = SubbreedsListFragmentDirections.actionSubbreedToPhotos(subbreed)
        view.findNavController().navigate(direction)
    }

    companion object {
        fun from(parent: ViewGroup): SubBreedViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemBreedBinding.inflate(layoutInflater, parent, false)
            return SubBreedViewHolder(binding)
        }
    }
}