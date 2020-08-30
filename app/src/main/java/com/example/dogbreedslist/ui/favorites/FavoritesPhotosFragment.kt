package com.example.dogbreedslist.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.dogbreedslist.databinding.FragmentDogsPhotosBinding
import com.example.dogbreedslist.ui.breeds.DogPhotosViewModel
import com.example.dogbreedslist.ui.breeds.adapters.DogPhotoAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesPhotosFragment : Fragment() {

    private lateinit var binding: FragmentDogsPhotosBinding
    private lateinit var currentImageUrl: String
    private lateinit var favoritesViewModel: FavoritesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDogsPhotosBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val imageAdapter = context?.let { DogPhotoAdapter(it) }

        favoritesViewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)
        favoritesViewModel.favoritesPhotos.observe(
            viewLifecycleOwner,
            Observer<List<String>> { images ->
                images.let {
                    imageAdapter?.setImages(it)
                }
            })
        //favoritesViewModel.fetchPhotos()

        return binding.root
    }

    private fun initViewPager(
        binding: FragmentDogsPhotosBinding,
        favoritesViewModel: FavoritesViewModel,
        adapter: DogPhotoAdapter
    ) {
        val viewPager = binding.photosViewPager

        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                currentImageUrl = favoritesViewModel.favoritesPhotos.value!![position]
            }

            override fun onPageSelected(position: Int) {}

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}
