package com.example.dogbreedslist.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogbreedslist.R
import com.example.dogbreedslist.databinding.FragmentBreedlistBinding
import com.example.dogbreedslist.ui.breeds.adapters.SubBreedAdapter
import com.example.dogbreedslist.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_breedlist.*

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
        favoritesViewModel.fetchFavorites()
        context ?: return binding.root
        subscribeUI()
        return binding.root

        //return inflater.inflate(R.layout.fragment_breedlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //subscribeUI()
    }

    private fun subscribeUI() {
        val favorites = favoritesViewModel.favoritesBreeds.value
        val layoutManager = LinearLayoutManager(requireContext())
        breed_list.layoutManager = layoutManager
        val favoritesAdapter = favorites?.let { SubBreedAdapter(it, "no subbreeds") }
        breed_list.adapter = favoritesAdapter
        favoritesViewModel.favoritesBreeds.observe(
            viewLifecycleOwner,
            Observer<List<String>> {
                favoritesAdapter?.submitList(it)
            })
        val rh = favoritesViewModel.favoritesBreeds.value

    }
}