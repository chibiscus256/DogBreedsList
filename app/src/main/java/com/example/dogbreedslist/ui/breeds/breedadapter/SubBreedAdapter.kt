package com.example.dogbreedslist.ui.breeds.breedadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.ui.breeds.BreedListViewModel

class SubBreedAdapter(private val viewModel: BreedListViewModel,
                      private val subbreeds: List<String>): RecyclerView.Adapter<SubBreedViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubBreedViewHolder {
        return SubBreedViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return subbreeds.size
    }

    override fun onBindViewHolder(viewHolderBreed: SubBreedViewHolder, position: Int) {
        viewHolderBreed.bind(viewModel, subbreeds[position])
    }
}