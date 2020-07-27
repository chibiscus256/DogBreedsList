package com.example.dogbreedslist.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dogbreedslist.ui.breeds.BreedListFragment
import com.example.dogbreedslist.ui.DogFragment

const val DOG_PAGE_INDEX = 0
const val DOGS_LIST_PAGE_INDEX = 1

class ApplicationPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    /**
     * Mapping of the ViewPager page indexes to their respective Fragments
     */
    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        DOG_PAGE_INDEX to { DogFragment() },
        DOGS_LIST_PAGE_INDEX to { BreedListFragment() }
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}