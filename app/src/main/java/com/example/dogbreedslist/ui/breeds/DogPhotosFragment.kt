package com.example.dogbreedslist.ui.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.local.favorites.FavoriteData
import com.example.dogbreedslist.data.network.dto.BreedImages
import com.example.dogbreedslist.databinding.FragmentDogsPhotosBinding
import com.example.dogbreedslist.ui.breeds.adapters.DogsPhotosAdapter
import com.example.dogbreedslist.utils.setTitle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DogPhotosFragment : Fragment() {

    private val dogPhotosViewModel: DogPhotosViewModel by activityViewModels()
    private lateinit var currentImageUrl : String
    private lateinit var binding: FragmentDogsPhotosBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDogsPhotosBinding.inflate(inflater, container, false)
        context ?: return binding.root
        init()
        return binding.root
    }

    private fun init(){
        initViewPager(binding, dogPhotosViewModel)
        setTitle(getBreedInfo().capitalize())
        binding.apply {
            setClickListener { like() } }
    }

    private fun like() {
        val cv = FavoriteData(name = getBreedInfo(), photoUrl = currentImageUrl)
        dogPhotosViewModel.addToFavorites(FavoriteData(name = getBreedInfo(), photoUrl = currentImageUrl))
        Toast.makeText(context, "Added to your favorites", Toast.LENGTH_LONG).show()
    }

    fun getBreedName(): String {
        return arguments?.getString("breedName").toString()
    }

    fun getSubbreedName(): String {
        return arguments?.getString("subbreedName").toString()
    }

    fun getBreedInfo(): String {
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
                currentImageUrl = viewModel.photos.value?.data?.images!![position]
            }

            override fun onPageSelected(position: Int) {}

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}