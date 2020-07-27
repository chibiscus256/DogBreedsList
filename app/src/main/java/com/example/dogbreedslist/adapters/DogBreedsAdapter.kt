package com.example.dogbreedslist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.databinding.ItemBreedBinding
import com.example.dogbreedslist.ui.base.RecyclerItemListener
import com.example.dogbreedslist.viewmodels.BreedsViewModel

class DogBreedsAdapter(private val viewModel: BreedsViewModel) :
    ListAdapter<Breed, DogBreedsAdapter.ViewHolder>((BreedDiffCallback())) {

    val mDogBreedList: ArrayList<Breed> = ArrayList()

    private val onItemClickListener: RecyclerItemListener = object : RecyclerItemListener {
        override fun onItemSelected(item: Breed) {
            //newsListViewModel.openNewsDetails(item)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return mDogBreedList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        //holder.bind(createOnClickListener(item.id), mDogBreedList[position])
    }

    class ViewHolder private constructor(val binding: ItemBreedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Breed) {
            binding.apply{
                clickListener = listener
                breed = item
                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemBreedBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
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
