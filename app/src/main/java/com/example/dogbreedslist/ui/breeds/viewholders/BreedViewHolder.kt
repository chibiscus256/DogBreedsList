package com.example.dogbreedslist.ui.breeds.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.databinding.ItemBreedBinding
import com.example.dogbreedslist.ui.breeds.BreedListFragmentDirections

class BreedViewHolder private constructor(val binding: ItemBreedBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Breed) {
        binding.apply {
            breed = item
            setClickListener { navigateToSubbreeds(breed?.subbreeds.isNullOrEmpty(), item, it) }
            executePendingBindings()
        }
    }

    private fun navigateToSubbreeds(isSubbreedsNotExist: Boolean, breed: Breed, view: View) {
        if (isSubbreedsNotExist) openDogsPhotos(breed, view)
        else {
            val subbreeds = breed.subbreeds!!.toTypedArray()
            val direction = BreedListFragmentDirections.actionBreedToSubbreed(breedName = breed.name, subbreeds =  subbreeds)
            view.findNavController().navigate(direction)
        }
    }

    private fun openDogsPhotos(breed: Breed, view: View) {
        val direction = breed.name.let { name -> BreedListFragmentDirections.actionBreedToPhotos(breedName = name, subbreedName = "no subbreeds")}
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