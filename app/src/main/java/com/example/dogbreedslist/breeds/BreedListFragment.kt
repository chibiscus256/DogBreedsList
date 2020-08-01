package com.example.dogbreedslist.breeds

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dogbreedslist.databinding.FragmentBreedlistBinding
import com.example.dogbreedslist.di.DblViewModelFactory
import com.example.dogbreedslist.breeds.breedadapter.BreedAdapter
import javax.inject.Inject


class BreedListFragment : Fragment() {

    @Inject
    lateinit var breedListListViewModel: BreedListViewModel
    @Inject
    lateinit var viewModelFactory: DblViewModelFactory

    private lateinit var binding: FragmentBreedlistBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreedlistBinding.inflate(inflater, container, false)
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
