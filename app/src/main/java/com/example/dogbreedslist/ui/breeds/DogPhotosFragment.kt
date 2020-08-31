package com.example.dogbreedslist.ui.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.adapters.ViewBindingAdapter.setClickListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.local.favorites.FavoriteData
import com.example.dogbreedslist.databinding.FragmentDogsPhotosBinding
import com.example.dogbreedslist.ui.breeds.adapters.DogPhotoAdapter
import com.example.dogbreedslist.utils.setTitle
import com.example.dogbreedslist.utils.toGone
import com.example.dogbreedslist.utils.toVisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DogPhotosFragment : Fragment() {

    private lateinit var dogPhotosViewModel: DogPhotosViewModel
    private lateinit var currentImageUrl: String
    private lateinit var binding: FragmentDogsPhotosBinding

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
        dogPhotosViewModel.fetchPhotos(getBreedName(), getSubbreedName())

        setTitle(getBreedInfo().capitalize())
        binding.apply {
            setClickListener { declareAttitude() }
        }

        return binding.root
    }

    private fun declareAttitude() {
        if (binding.btnUnlove.isVisible) addToFavorites() else {
            removeFromFavorites()
        }
    }

    private fun addToFavorites() {
        like()
        dogPhotosViewModel.addToFavorites(
            FavoriteData(
                name = getBreedInfo(),
                photoUrl = currentImageUrl
            )
        )
        Toast.makeText(context, "Added to your favorites", Toast.LENGTH_SHORT).show()
    }

    private fun removeFromFavorites() {
        unlike()
        dogPhotosViewModel.deleteFavorite(
            FavoriteData(
                name = getBreedInfo(),
                photoUrl = currentImageUrl
            )
        )
        Toast.makeText(context, "Removed from your favorites", Toast.LENGTH_SHORT).show()
    }

    private fun unlike() {
        binding.btnUnlove.toVisible()
        binding.btnLove.toGone()
    }

    private fun like() {
        binding.btnLove.toVisible()
        binding.btnUnlove.toGone()
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

    private fun initViewPager(
        binding: FragmentDogsPhotosBinding,
        viewModel: DogPhotosViewModel,
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
                unlike()
                val currentItemUrl = viewModel.photos.value?.data!![position]
                val storedPhotos = dogPhotosViewModel.storedPhotos.value
                currentImageUrl = currentItemUrl
                if (storedPhotos != null && storedPhotos.contains(currentItemUrl)) {
                    like()
                }
            }

            override fun onPageSelected(position: Int) {}

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}