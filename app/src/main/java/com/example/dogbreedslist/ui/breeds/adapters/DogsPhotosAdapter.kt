package com.example.dogbreedslist.ui.breeds.adapters

import android.content.Context
import android.view.View
import androidx.viewpager.widget.PagerAdapter

class DogsPhotosAdapter constructor(private val context: Context) : PagerAdapter() {

    var photos: List<String> = listOf()

    override fun getCount(): Int {
        return photos.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    fun setImages(images: List<String>){
        photos = images
        notifyDataSetChanged()
    }

}