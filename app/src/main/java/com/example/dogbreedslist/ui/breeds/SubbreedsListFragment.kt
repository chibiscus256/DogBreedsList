package com.example.dogbreedslist.ui.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogbreedslist.R
import com.example.dogbreedslist.databinding.FragmentBreedlistBinding
import com.example.dogbreedslist.utils.autoCleared
import com.example.dogbreedslist.utils.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SubbreedsListFragment : Fragment(){

    var binding: FragmentBreedlistBinding by autoCleared()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_breedlist,
            container,
            false)
        context ?: return binding.root
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        val layoutManager = LinearLayoutManager(requireContext())
        binding.breedList.layoutManager = layoutManager
    }
}