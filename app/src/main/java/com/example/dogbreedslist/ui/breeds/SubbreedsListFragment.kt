package com.example.dogbreedslist.ui.breeds

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogbreedslist.R
import com.example.dogbreedslist.databinding.FragmentBreedlistBinding
import com.example.dogbreedslist.databinding.FragmentSubbreedlistBinding
import com.example.dogbreedslist.ui.breeds.breedadapter.SubBreedAdapter
import com.example.dogbreedslist.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SubbreedsListFragment : Fragment() {

    private val breedListViewModel = ViewModelProvider(this).get(BreedListViewModel::class.java)
    var binding: FragmentSubbreedlistBinding by autoCleared()

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "subbreeds onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "subbreeds onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "subbreeds onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "subbreeds onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "subbreeds onDestroy")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_subbreedlist,
            container,
            false
        )
        context ?: return binding.root
        println("============================================================================")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext())
        binding.breedList.layoutManager = layoutManager
        val subBreeds = breedListViewModel._subbreedClicked.value
        val breedsAdapter = subBreeds?.let { SubBreedAdapter(breedListViewModel, it) }
        binding.breedList.adapter = breedsAdapter
    }

}