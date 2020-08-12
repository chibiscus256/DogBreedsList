package com.example.dogbreedslist.ui.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.dogbreedslist.ui.breeds.breedadapter.BreedAdapter
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.network.dto.BreedList
import com.example.dogbreedslist.databinding.FragmentBreedlistBinding
import com.example.dogbreedslist.utils.autoCleared
import com.example.dogbreedslist.utils.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreedListFragment : Fragment() {

    private val breedListViewModel: BreedListViewModel by activityViewModels()

    var binding: FragmentBreedlistBinding by autoCleared()
    private lateinit var breedListAdapter: BreedAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreedlistBinding.inflate(inflater, container, false)
        context ?: return binding.root

        setHasOptionsMenu(true)
        observe(breedListViewModel.breedList, ::handleList)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        init()
    }

    private fun bindListData(breedList: BreedList) {
        if (!(breedList.breeds.isNullOrEmpty())) {
            val breedsAdapter = BreedAdapter(breedListViewModel, breedList.breeds)
            binding.breedList.adapter = breedsAdapter
        }
    }

    private fun handleList(breedList: Resource<BreedList>) {
        when (breedList) {
            is Resource.Success -> breedList.data?.let { bindListData(breedList = it) }
        }
    }

    private fun init() {
        breedListViewModel.getBreeds()
    }
}
