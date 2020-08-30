package com.example.dogbreedslist.ui.breeds.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreedslist.ui.breeds.viewholders.SubBreedViewHolder

class SubBreedAdapter(
    private val subbreeds: List<String>,
    private val breedName: String
) : ListAdapter<String, SubBreedViewHolder>((DiffCallback())) {

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

//Не знаю, так нормально вообще делать? Мне Data class тут не нужен просто, только строка
class DiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}
