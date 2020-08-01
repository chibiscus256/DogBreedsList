package com.example.dogbreedslist.breeds.breedadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.breeds.BreedListViewModel

class BreedAdapter(private val viewModel: BreedListViewModel) :
    ListAdapter<Breed, BreedViewHolder>((BreedDiffCallback())) {

    val mDogBreedList: ArrayList<Breed> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        return BreedViewHolder.from(
            parent
        )
    }

    override fun getItemCount(): Int {
        return mDogBreedList.size
    }

    override fun onBindViewHolder(holderBreed: BreedViewHolder, position: Int) {
        val item = getItem(position)
        holderBreed.bind(viewModel, mDogBreedList[position])
    }
}

class BreedDiffCallback : DiffUtil.ItemCallback<Breed>() {
    override fun areItemsTheSame(oldItem: Breed, newItem: Breed): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Breed, newItem: Breed): Boolean {
        return oldItem == newItem
    }
}
