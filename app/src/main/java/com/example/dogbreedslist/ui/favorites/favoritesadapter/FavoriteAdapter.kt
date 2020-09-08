package com.example.dogbreedslist.ui.favorites.favoritesadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.dogbreedslist.data.local.breeds.BreedData
import com.example.dogbreedslist.databinding.ItemFavoriteBinding
import com.example.dogbreedslist.ui.breeds.adapters.DiffCallback
import com.example.dogbreedslist.viewmodel.FavoritesViewModel

/*Хотел адаптером списка понравившихся пород сделать SubbreedAdapter, но список начинал отображаться только
после второго попадания на FavoritresFragment (т.к в первый раз RecyclerView инициировалось пустым).
 Использование getItem в вместо выбора элемента передаваемого списка в конструкторе помогла, но тогда перестал
 отображаться список подпород в SubbreedsListFragment, а вызов getItem(position) с переданным списком
 подпород вызывал IndexOutOfBoundsException. В общем, я не понял, как это работает*/

class FavoriteAdapter(private val viewModel: FavoritesViewModel) : ListAdapter<BreedData, FavoriteViewHolder>(BreedDataDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(viewHolderBreed: FavoriteViewHolder, position: Int) {
        viewHolderBreed.bind(getItem(position), viewModel)
    }
}
class BreedDataDiffCallback : DiffUtil.ItemCallback<BreedData>() {
    override fun areItemsTheSame(oldItem: BreedData, newItem: BreedData): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: BreedData, newItem: BreedData): Boolean {
        return oldItem == newItem
    }
}
