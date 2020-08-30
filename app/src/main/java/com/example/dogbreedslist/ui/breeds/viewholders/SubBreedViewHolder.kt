package com.example.dogbreedslist.ui.breeds.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreedslist.databinding.ItemBreedBinding
import com.example.dogbreedslist.ui.breeds.BreedListViewModel
import com.example.dogbreedslist.ui.breeds.SubbreedsListFragmentDirections

class SubBreedViewHolder private constructor(val binding: ItemBreedBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: String, breedName: String) {

        binding.apply {
            subbreed = item
            setClickListener { openDogsPhotos(item, it, breedName) }
            executePendingBindings()
        }
    }

    private fun openDogsPhotos(subbreed: String, view: View, breedName: String) {
        val direction = SubbreedsListFragmentDirections.actionSubbreedToPhotos(breedName, subbreed)
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