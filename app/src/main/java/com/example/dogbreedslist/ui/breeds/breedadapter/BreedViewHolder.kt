package com.example.dogbreedslist.ui.breeds.breedadapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.databinding.ItemBreedBinding
import com.example.dogbreedslist.ui.breeds.BreedListFragmentDirections
import com.example.dogbreedslist.ui.breeds.BreedListViewModel
import com.example.dogbreedslist.utils.TransferUtils
import java.util.ArrayList

class BreedViewHolder private constructor(val binding: ItemBreedBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(viewModel: BreedListViewModel, item: Breed) {

        binding.apply {
            binding.breedListViewModel = viewModel
            breed = item
            setClickListener { navigateToSubbreeds(breed?.subbreeds.isNullOrEmpty(), item, it) }
            executePendingBindings()
        }
    }

    private fun navigateToSubbreeds(isSubbreedsNotExist: Boolean, breed: Breed, view: View) {
        if (isSubbreedsNotExist) openDogsPhotos(breed, view)
        else {
            val args = breed.subbreeds!!.toTypedArray()
            val direction = BreedListFragmentDirections.actionBreedToSubbreed(args)
            view.findNavController().navigate(direction)
        }
    }

    private fun openDogsPhotos(breed: Breed, view: View) {
        val direction = breed.name.let { name -> BreedListFragmentDirections.actionBreedToPhotos(name)}
        direction.let { view.findNavController().navigate(it) }
    }

    companion object {
        fun from(parent: ViewGroup): BreedViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemBreedBinding.inflate(layoutInflater, parent, false)
            return BreedViewHolder(binding)
        }
    }
}