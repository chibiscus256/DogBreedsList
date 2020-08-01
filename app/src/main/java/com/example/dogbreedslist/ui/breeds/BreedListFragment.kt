package com.example.dogbreedslist.ui.breeds

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dogbreedslist.databinding.FragmentBreedBinding
import com.example.dogbreedslist.di.DblViewModelFactory
import com.example.dogbreedslist.ui.breeds.breedadapter.BreedAdapter
import javax.inject.Inject


class BreedListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: DblViewModelFactory

    @Inject
    lateinit var breedListListViewModel: BreedListViewModel

    private lateinit var binding: FragmentBreedBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreedBinding.inflate(inflater, container, false)
        context ?: return binding.root

        initializeViewModel()

        val adapter =
            BreedAdapter(
                breedListListViewModel
            )
        binding.breedList.adapter = adapter

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun initializeViewModel() {
        breedListListViewModel = viewModelFactory.create(BreedListViewModel::class.java)
    }
}
