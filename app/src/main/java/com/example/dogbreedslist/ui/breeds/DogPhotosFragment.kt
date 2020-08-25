package com.example.dogbreedslist.ui.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.network.dto.BreedImages
import com.example.dogbreedslist.databinding.FragmentDogsPhotosBinding
import com.example.dogbreedslist.ui.breeds.adapters.DogsPhotosAdapter
import com.example.dogbreedslist.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DogPhotosFragment : Fragment() {

    val dogPhotosViewModel: DogPhotosViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDogsPhotosBinding.inflate(inflater, container, false)
        context ?: return binding.root
        initViewPager(binding)
        dogPhotosViewModel.getPhotos(
            arguments?.getString("breedName").toString(),
            arguments?.getString("subbreedName").toString()
        )
        return binding.root
    }

    private fun initViewModel(adapter: DogsPhotosAdapter) {
        dogPhotosViewModel.photos.observe(
            viewLifecycleOwner,
            Observer<Resource<BreedImages>> { images ->
                images?.let {
                    adapter.setImages(it.data)
                }
            })
    }

    private fun initViewPager(binding: FragmentDogsPhotosBinding) {
        val viewPager = binding.photosViewPager
        val imageAdapter = context?.let { DogsPhotosAdapter(it) }
        viewPager.adapter = imageAdapter
        imageAdapter?.let { initViewModel(it) }
    }
}