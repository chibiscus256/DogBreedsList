package com.example.dogbreedslist.ui.breeds.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreedslist.ui.breeds.BreedListViewModel
import com.example.dogbreedslist.ui.breeds.viewholders.SubBreedViewHolder

class SubBreedAdapter(private val subbreeds: List<String>,
                      private val breedName: String): RecyclerView.Adapter<SubBreedViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubBreedViewHolder {
        return SubBreedViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return subbreeds.size
    }

    override fun onBindViewHolder(viewHolderBreed: SubBreedViewHolder, position: Int) {
        viewHolderBreed.bind(subbreeds[position], breedName)
    }
}