package com.example.dogbreedslist.ui.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.dogbreedslist.R
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.local.favorites.FavoriteData
import com.example.dogbreedslist.databinding.FragmentDogsPhotosBinding
import com.example.dogbreedslist.ui.breeds.adapters.DogPhotoAdapter
import com.example.dogbreedslist.ui.favorites.FavoritesViewModel
import com.example.dogbreedslist.utils.setTitle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_dogs_photos.*

@AndroidEntryPoint
class DogPhotosFragment : Fragment() {

    private lateinit var dogPhotosViewModel: DogPhotosViewModel
    private lateinit var currentImageUrl : String
    private lateinit var binding: FragmentDogsPhotosBinding
    private var attractivenessOfPicture: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDogsPhotosBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val imageAdapter = context?.let { DogPhotoAdapter(it) }
        if (imageAdapter != null) {
            initViewModel(imageAdapter)
            initViewPager(binding, dogPhotosViewModel, imageAdapter)
        }
        dogPhotosViewModel.getPhotos(getBreedName(), getSubbreedName())

        setTitle(getBreedInfo().capitalize())
        binding.apply {
            setClickListener { indicateAttitude(attractivenessOfPicture)} }

        return binding.root
    }


    private fun indicateAttitude(prettiness: Boolean) {
        if (!prettiness) like() else {
            unlike()
        }
    }

    private fun like() {
        dogPhotosViewModel.addToFavorites(FavoriteData(name = getBreedInfo(), photoUrl = currentImageUrl))
        Toast.makeText(context, "Added to your favorites", Toast.LENGTH_SHORT).show()
        btn_love.setImageResource(R.drawable.ic_love)
        attractivenessOfPicture = true
    }

    private fun unlike(){
        dogPhotosViewModel.deleteFavorite(FavoriteData(name = getBreedInfo(), photoUrl = currentImageUrl))
        Toast.makeText(context, "Removed from your favorites", Toast.LENGTH_SHORT).show()
        btn_love.setImageResource(R.drawable.ic_love_border)
        attractivenessOfPicture = false
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

    private fun initViewModel(adapter: DogPhotoAdapter) {
        dogPhotosViewModel = ViewModelProvider(this).get(DogPhotosViewModel::class.java)
        dogPhotosViewModel.photos.observe(
            viewLifecycleOwner,
            Observer<Resource<List<String>>> { images ->
                images?.let {
                    adapter.setImages(it.data!!)
                }
            })
    }

    private fun initViewPager(binding: FragmentDogsPhotosBinding, viewModel: DogPhotosViewModel, adapter: DogPhotoAdapter) {
        val viewPager = binding.photosViewPager
        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                currentImageUrl = viewModel.photos.value?.data!![position]
            }

            override fun onPageSelected(position: Int) {}

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}