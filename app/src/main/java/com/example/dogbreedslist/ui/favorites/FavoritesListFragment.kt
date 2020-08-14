package com.example.dogbreedslist.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreedslist.R
import com.example.dogbreedslist.databinding.FragmentFavoritesBinding
import com.example.dogbreedslist.ui.favorites.favoritesadapter.FavoritesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesListFragment : Fragment() {

    lateinit var mRecyclerView: RecyclerView
    lateinit var favoritesAdapter: FavoritesAdapter
    lateinit var binding: FragmentFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initRecyclerView()
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    private fun initRecyclerView() {
        binding.favoritesList.layoutManager = LinearLayoutManager(context)
        favoritesAdapter
    }
}