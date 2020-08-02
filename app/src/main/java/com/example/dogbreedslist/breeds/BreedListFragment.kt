package com.example.dogbreedslist.breeds

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dogbreedslist.databinding.ItemBreedBinding
import com.example.dogbreedslist.di.DblViewModelFactory
import com.example.dogbreedslist.breeds.breedadapter.BreedAdapter
import javax.inject.Inject


class BreedListFragment : Fragment() {

    @Inject
    lateinit var breedListViewModel: BreedListViewModel
    @Inject
    lateinit var viewModelFactory: DblViewModelFactory

    private lateinit var binding: ItemBreedBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemBreedBinding.inflate(inflater, container, false)
        context ?: return binding.root

        initializeViewModel()

        val adapter =
            BreedAdapter(
                breedListViewModel
            )
        //binding.breedList.adapter = adapter

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun initializeViewModel() {
        breedListViewModel = viewModelFactory.create(BreedListViewModel::class.java)
    }
}
