package com.example.dogbreedslist.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogbreedslist.R
import com.example.dogbreedslist.databinding.FragmentFavoritesBinding
import com.example.dogbreedslist.ui.favorites.favoritesadapter.FavoritesAdapter
import com.example.dogbreedslist.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesListFragment : Fragment() {

    lateinit var adapter: FavoritesAdapter
    private var binding: FragmentFavoritesBinding by autoCleared()
    private val favoritesViewModel : FavoritesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvFavoritesList.layoutManager = LinearLayoutManager(context)
        binding.rvFavoritesList.adapter = FavoritesAdapter(favoritesViewModel)
        favoritesViewModel.prepareItems()
    }
}