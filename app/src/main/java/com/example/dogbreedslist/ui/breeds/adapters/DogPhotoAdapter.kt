package com.example.dogbreedslist.ui.breeds.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.signature.ObjectKey
import com.example.dogbreedslist.R
import com.example.dogbreedslist.data.network.dto.BreedImages
import com.example.dogbreedslist.databinding.BreedImageBinding
import java.lang.System.currentTimeMillis

class DogPhotoAdapter(private val context: Context) : PagerAdapter() {

    var photos: List<String> = listOf()

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageBinding: BreedImageBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.breed_image,
                container,
                false
            )
        val imageView = imageBinding.image

        Glide.with(context)
            .load(photos[position])
            .signature(ObjectKey(currentTimeMillis().toString()))
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .placeholder(R.drawable.iggy)
            .into(imageView)
        container.addView(imageBinding.root)
        return imageBinding.root
        TODO("prevent Glide caching, methods called here does not help")
        /*
        Я не знаю, почему Glide продолжает кешировать объем данных в 2 фотографии, воткнутые методы не делают, что должны,
        гугл и профильные чаты не помогли. Смотрел в пример с собачаками на MVP, там все клево и без
        методов, я не знаю, почему
        */
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return photos.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    fun setImages(breedImages: BreedImages?) {
        if (breedImages != null) photos = breedImages.images
        notifyDataSetChanged()
    }

}