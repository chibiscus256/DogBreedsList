package com.example.dogbreedslist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.dogbreedslist.ui.adapters.ApplicationPagerAdapter
import com.example.dogbreedslist.databinding.FragmentViewPagerBinding
import dagger.android.AndroidInjection

class HomeViewPagerFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        val viewPager = binding.viewPager

        viewPager.adapter = ApplicationPagerAdapter(this)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        return binding.root
    }
}
