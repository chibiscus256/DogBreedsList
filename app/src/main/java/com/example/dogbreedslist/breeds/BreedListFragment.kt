package com.example.dogbreedslist.breeds

import android.app.FragmentBreadCrumbs
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dogbreedslist.R
import com.example.dogbreedslist.databinding.ItemBreedBinding
import com.example.dogbreedslist.di.DblViewModelFactory
import com.example.dogbreedslist.breeds.breedadapter.BreedAdapter
import com.example.dogbreedslist.databinding.FragmentBreedlistBinding
import com.example.dogbreedslist.utils.autoCleared
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_breedlist.view.*
import javax.inject.Inject


class BreedListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    var binding: FragmentBreedlistBinding by autoCleared()
    private lateinit var breedListAdapter: BreedAdapter

    private val breedListViewModel: BreedListViewModel by viewModels {
        viewModelFactory
    }

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
