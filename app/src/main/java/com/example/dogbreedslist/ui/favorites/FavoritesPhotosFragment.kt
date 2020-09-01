package com.example.dogbreedslist.ui.favorites

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
import com.example.dogbreedslist.data.local.favorites.FavoriteData
import com.example.dogbreedslist.databinding.FragmentDogsPhotosBinding
import com.example.dogbreedslist.ui.breeds.DogPhotosViewModel
import com.example.dogbreedslist.ui.breeds.adapters.DogPhotoAdapter
import com.example.dogbreedslist.utils.setTitle
import com.example.dogbreedslist.utils.toGone
import com.example.dogbreedslist.utils.toVisible
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.notifyAll

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

        if (imageAdapter != null) {
            initViewModel(imageAdapter)
            initViewPager(binding, favoritesViewModel, imageAdapter)
        }

        favoritesViewModel.fetchPhotos(getBreedName())
        initUI(getBreedName())

        return binding.root
    }

    fun getBreedName(): String{
        return arguments?.getString("breedName").toString()
    }

    private fun initUI(title: String) {
        setTitle(title.capitalize())
        binding.apply {
            btnLove.toVisible()
            setClickListener { unlike() }
        }
    }

    private fun unlike(){
        favoritesViewModel.deleteFavoritePhoto(
            FavoriteData(name = getBreedName(), photoUrl = currentImageUrl)
        )
        Toast.makeText(context, "Removed from your favorites", Toast.LENGTH_SHORT).show()
        binding.btnLove.toGone()
    }

    private fun initViewModel(imageAdapter: DogPhotoAdapter) {
        favoritesViewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)
        favoritesViewModel.favoritesPhotos.observe(
            viewLifecycleOwner,
            Observer<List<String>> { images ->
                images.let {
                    imageAdapter.setImages(it)
                }
            })

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

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }
}
