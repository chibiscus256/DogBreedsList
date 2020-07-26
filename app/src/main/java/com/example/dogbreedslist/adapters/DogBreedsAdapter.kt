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
import com.example.dogbreedslist.ui.DogFragment
import com.example.dogbreedslist.ui.BreedListFragment
import com.example.dogbreedslist.ui.RecyclerViewActionListener

class DogBreedsAdapter(context: Context) : RecyclerView.Adapter<DogBreedsAdapter.ItemDogBreed>() {
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



    fun addData(data: List<String>) {
        mDogBreed.addAll(data)
        notifyDataSetChanged()
    }


    fun removeAllData() {
        mDogBreed.clear()
    }

    class ItemDogBreed(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(breed: String, mActionItemListener: RecyclerViewActionListener<String>) {
            itemView.textview_breed.text = CommonUtils.uppercaseTheFirstLetter(breed)
            itemView.setOnClickListener {
                mActionItemListener.onItemClick(breed)
            }
        }
    }

    override fun onBindViewHolder(holder: ItemDogBreed, position: Int) {
        holder.bind(mDogBreed[position], mActionItemListener)
    }
}