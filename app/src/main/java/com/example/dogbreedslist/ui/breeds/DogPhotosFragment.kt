package com.example.dogbreedslist.ui.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.network.dto.BreedImages
import com.example.dogbreedslist.databinding.FragmentDogsPhotosBinding
import com.example.dogbreedslist.ui.breeds.adapters.DogsPhotosAdapter
import com.example.dogbreedslist.utils.setTitle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DogPhotosFragment : Fragment() {

    val dogPhotosViewModel: DogPhotosViewModel by activityViewModels()
    private lateinit var currentImageUrl : String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDogsPhotosBinding.inflate(inflater, container, false)
        context ?: return binding.root
        initViewPager(binding, dogPhotosViewModel)
        setTitle(getTitleText().capitalize())
        return binding.root
    }

    fun getBreedName(): String {
        return arguments?.getString("breedName").toString()
    }

    fun getSubbreedName(): String {
        return arguments?.getString("subbreedName").toString()
    }

    fun getTitleText(): String {
        return if (getSubbreedName() == "no subbreeds") {
            return getBreedName()
        } else
            getSubbreedName()
    }

    private fun initViewModel(adapter: DogsPhotosAdapter) {
        dogPhotosViewModel.photos.observe(
            viewLifecycleOwner,
            Observer<Resource<BreedImages>> { images ->
                images?.let {
                    adapter.setImages(it.data)
                }
            })
        dogPhotosViewModel.getPhotos(getBreedName(), getSubbreedName())
    }

    private fun initViewPager(binding: FragmentDogsPhotosBinding, viewModel: DogPhotosViewModel) {
        val viewPager = binding.photosViewPager
        val imageAdapter = context?.let { DogsPhotosAdapter(it) }
        viewPager.adapter = imageAdapter
        if (imageAdapter != null) {
            initViewModel(imageAdapter)
        }
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                TODO("Not yet implemented")
            }

            override fun onPageSelected(position: Int) {
                currentImageUrl = viewModel.photos.value?.data?.images!![position]
            }

            override fun onPageScrollStateChanged(state: Int) {
                TODO("Not yet implemented")
            }
        })
    }
}