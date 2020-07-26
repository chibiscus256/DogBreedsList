package com.example.dogbreedslist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dogbreedslist.databinding.FragmentBreedBinding
import com.example.dogbreedslist.viewmodels.BreedListViewModel
import com.example.dogbreedslist.viewmodels.ViewModelFactory
import javax.inject.Inject

class BreedListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var breedListViewModel: BreedListViewModel

    private lateinit var binding: FragmentBreedBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreedBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = BreedAdapter()
        binding.plantList.adapter = adapter
        subscribeUi(adapter)

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun subscribeUi(adapter: PlantAdapter) {
        breedListViewModel.plants.observe(viewLifecycleOwner) { plants ->
            adapter.submitList(plants)
        }
    }
}