package com.example.dogbreedslist.ui.favorites

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
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
        favoritesViewModel.fetchFavorites()

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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i(ContentValues.TAG, "favorites onAttach")
    }

    override fun onResume() {
        super.onResume()
        Log.i(ContentValues.TAG, "favorites onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i(ContentValues.TAG, "favorites onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.i(ContentValues.TAG, "favorites onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.i(ContentValues.TAG, "favorites onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(ContentValues.TAG, "favorites onDestroy")
    }

}