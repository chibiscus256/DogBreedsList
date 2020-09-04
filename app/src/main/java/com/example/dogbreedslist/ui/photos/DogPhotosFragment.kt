package com.example.dogbreedslist.ui.photos

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.dogbreedslist.R
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.local.favorites.FavoriteData
import com.example.dogbreedslist.databinding.FragmentDogsPhotosBinding
import com.example.dogbreedslist.utils.intentShareText
import com.example.dogbreedslist.utils.setTitle
import com.example.dogbreedslist.utils.toGone
import com.example.dogbreedslist.viewmodel.DogPhotosViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

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
        initUI()
        setHasOptionsMenu(true)
        dogPhotosViewModel.fetchPhotos(getBreedName(), getSubbreedName())

        return binding.root
    }

    private fun initUI() {
        setTitle(getBreedInfo().capitalize())
        activity?.bottom_nav?.toGone()
        binding.apply {

        }
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

/*    private fun declareAttitude(url: String) {
        if (binding.btnUnlove.isVisible) addToFavorites(url) else {
            removeFromFavorites(url)
        }
    }*/

    private fun addToFavorites(url: String) {
        //like()
        dogPhotosViewModel.addToFavorites(
            FavoriteData(
                name = getBreedInfo(),
                photoUrl = url
            )
        )
        Toast.makeText(context, "Added to your favorites", Toast.LENGTH_SHORT).show()
    }

    private fun removeFromFavorites(url: String) {
        //unlike()
        dogPhotosViewModel.deleteFavorite(
            FavoriteData(
                name = getBreedInfo(),
                photoUrl = url
            )
        )
        Toast.makeText(context, "Removed from your favorites", Toast.LENGTH_SHORT).show()
    }

/*    private fun unlike() {
        binding.btnUnlove.toVisible()
        binding.btnLove.toGone()
    }

    private fun like() {
        binding.btnLove.toVisible()
        binding.btnUnlove.toGone()
    }*/


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
                images.let {
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
                //unlike()
                val currentItemUrl = viewModel.photos.value?.data!![position]
                currentImageUrl = currentItemUrl
            }

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
    }
}