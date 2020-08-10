package com.example.dogbreedslist.breeds.breedadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.dogbreedslist.data.network.dto.BreedData
import com.example.dogbreedslist.breeds.BreedListViewModel

class BreedAdapter(private val viewModel: BreedListViewModel) :
    ListAdapter<BreedData, BreedViewHolder>((BreedDiffCallback())) {

    val mDogBreedDataList: ArrayList<BreedData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        return BreedViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return mDogBreedDataList.size
    }

    override fun onBindViewHolder(holderBreed: BreedViewHolder, position: Int) {
        val item = getItem(position)
        holderBreed.bind(viewModel, mDogBreedDataList[position])
    }
}

class BreedDiffCallback : DiffUtil.ItemCallback<BreedData>() {
    override fun areItemsTheSame(oldItem: BreedData, newItem: BreedData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BreedData, newItem: BreedData): Boolean {
        return oldItem == newItem
    }
}
