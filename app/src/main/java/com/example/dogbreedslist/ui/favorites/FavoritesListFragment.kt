package com.example.dogbreedslist.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogbreedslist.databinding.FragmentBreedlistBinding
import com.example.dogbreedslist.ui.favorites.favoritesadapter.FavoriteAdapter
import com.example.dogbreedslist.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesListFragment : Fragment() {

    private val favoritesViewModel: FavoritesViewModel by activityViewModels()
    var binding: FragmentBreedlistBinding by autoCleared()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreedlistBinding.inflate(
            inflater,
            container,
            false
        )
        context ?: return binding.root
        favoritesViewModel.fetchFavoritesBreeds()

        subscribeUI()
        return binding.root

        //return inflater.inflate(R.layout.fragment_breedlist, container, false)
    }

    private fun subscribeUI() {
        val layoutManager = LinearLayoutManager(requireContext())
        binding.breedList.layoutManager = layoutManager
        val favoritesAdapter = FavoriteAdapter()
        binding.breedList.adapter = favoritesAdapter
        favoritesViewModel.favoritesBreeds.observe(
            viewLifecycleOwner,
            Observer<List<String>> {
                favoritesAdapter.submitList(it)
            })
    }
}