package com.example.dogbreedslist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dogbreedslist.App.Companion.context
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.ui.DogFragment
import com.example.dogbreedslist.ui.BreedListFragment
import com.example.dogbreedslist.ui.RecyclerViewActionListener
import com.example.dogbreedslist.viewmodels.BreedListViewModel

class DogBreedsAdapter(private val viewModel: BreedListViewModel) : ListAdapter<Breed, DogBreedsAdapter.ViewHolder>((BreedDiffCallback())) {

    val mDogBreed: ArrayList<String> = ArrayList()
    val mActionItemListener: RecyclerViewActionListener<String> =
        context as RecyclerViewActionListener<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDogBreed {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_dog_breed, parent, false)
        return ItemDogBreed(view)
    }

    override fun getItemCount(): Int {
        return mDogBreed.size
    }

    override fun onBindViewHolder(holder: ItemDogBreed, position: Int) {
        holder.bind(mDogBreed[position], mActionItemListener)
    }

    class ViewHolder private constructor(val binding: TaskItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: TasksViewModel, item: Task) {

            binding.viewmodel = viewModel
            binding.task = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TaskItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}