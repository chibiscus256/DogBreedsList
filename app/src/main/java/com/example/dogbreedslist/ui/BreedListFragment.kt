package com.example.dogbreedslist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dogbreedslist.adapters.BreedAdapter
import com.example.dogbreedslist.databinding.FragmentBreedBinding

class BreedListFragment : Fragment() {

    private lateinit var binding: FragmentBreedBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreedBinding.inflate(inflater, container, false)
    }
}