package com.example.dogbreedslist.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogbreedslist.data.local.breeds.BreedData
import com.example.dogbreedslist.databinding.FragmentBreedlistBinding
import com.example.dogbreedslist.ui.favorites.favoritesadapter.FavoriteAdapter
import com.example.dogbreedslist.utils.autoCleared
import com.example.dogbreedslist.utils.toVisible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

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
        initUi()
        return binding.root
    }

    private fun initUi() {
        activity?.bottom_nav?.toVisible()
        val layoutManager = LinearLayoutManager(requireContext())
        binding.breedList.layoutManager = layoutManager
        val favoritesAdapter = FavoriteAdapter(favoritesViewModel)
        binding.breedList.adapter = favoritesAdapter
        favoritesViewModel.favoritesBreeds.observe(
            viewLifecycleOwner,
            Observer<List<BreedData>> {
                favoritesAdapter.submitList(it)
            })
    }
}