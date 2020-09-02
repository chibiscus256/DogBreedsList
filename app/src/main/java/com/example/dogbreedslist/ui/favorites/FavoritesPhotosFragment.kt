package com.example.dogbreedslist.ui.favorites

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.*
import android.widget.Toast
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.dogbreedslist.R
import com.example.dogbreedslist.data.local.favorites.FavoriteData
import com.example.dogbreedslist.databinding.FragmentDogsPhotosBinding
import com.example.dogbreedslist.ui.breeds.DogPhotosViewModel
import com.example.dogbreedslist.ui.breeds.adapters.DogPhotoAdapter
import com.example.dogbreedslist.utils.intentShareText
import com.example.dogbreedslist.utils.setTitle
import com.example.dogbreedslist.utils.toGone
import com.example.dogbreedslist.utils.toVisible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.internal.notifyAll

/*Решил без наследования какого-нибудь BasePhotosFragment, потому что думаю, что поведение фрагментов
* с хранящимися фото и загруженными может и отличаться, врдуг отредактировать ументь захотим или плиточкой хранить,
* но тут много кода дублируется, да*/

@AndroidEntryPoint
class FavoritesPhotosFragment : Fragment() {

    private lateinit var binding: FragmentDogsPhotosBinding
    private lateinit var currentImageUrl: String
    private lateinit var favoritesViewModel: FavoritesViewModel
    private var storedPhotos : MutableList<String> = mutableListOf()

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
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_dogs_collection, menu)
    }

    @Suppress("DEPRECATION")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                intentShareText(requireActivity(), getString(R.string.share_dog_image))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun getBreedName(): String{
        return arguments?.getString("breedName").toString()
    }

    private fun initUI(title: String) {
        activity?.bottom_nav?.toGone()
        setTitle(title.capitalize())
        binding.apply {
            btnLove.toVisible()
            setClickListener { unlike(currentImageUrl) }
        }
    }

    private fun unlike(url: String){
        favoritesViewModel.deleteFavoritePhoto(
            FavoriteData(name = getBreedName(), photoUrl = url)
        )
        Toast.makeText(context, "Removed from your favorites", Toast.LENGTH_SHORT).show()
        storedPhotos.remove(url)
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
                if (currentImageUrl in favoritesViewModel.favoritesPhotos.value!!) binding.btnLove.toVisible()
            }

        })
    }
}
