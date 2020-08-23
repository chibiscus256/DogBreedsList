package com.example.dogbreedslist.ui.breeds.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.example.dogbreedslist.R
import com.example.dogbreedslist.databinding.BreedImageBinding
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DogsPhotosAdapter@Inject constructor(private val photos: List<String>, @ApplicationContext private val context: Context) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageBinding : BreedImageBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.breed_image, container, false)
        container.addView(imageBinding.root)
        return imageBinding.root
    }


    override fun getCount(): Int {
        return photos.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

}