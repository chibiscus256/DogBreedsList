package com.example.dogbreedslist.ui.breeds.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.dogbreedslist.ui.breeds.viewholders.SubBreedViewHolder

class SubBreedAdapter(
    private val subbreeds: List<String>,
    private val breedName: String
) : ListAdapter<String, SubBreedViewHolder>((StringDiffCallback())) {

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

//Не знаю, так нормально вообще делать? Строка это же не data class какой-нибудь, но мне в адаптере
//data class и не нужен как бы
class StringDiffCallback : DiffUtil.ItemCallback<String>(){
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

}
