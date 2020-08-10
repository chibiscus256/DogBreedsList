package com.example.dogbreedslist.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.dogbreedslist.breeds.breedadapter.BreedAdapter
import com.example.dogbreedslist.databinding.FragmentBreedlistBinding
import com.example.dogbreedslist.utils.autoCleared
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

        breedListAdapter = BreedAdapter(breedListViewModel)
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        initRecyclerView()
        init()
    }

    private fun init(){
        breedListViewModel.getBreeds()
    }

    private fun initRecyclerView() {

        breedListViewModel.breedList.observe(viewLifecycleOwner, Observer {let {
            breedListAdapter.mDogBreedList
        }
        })
    }
}
