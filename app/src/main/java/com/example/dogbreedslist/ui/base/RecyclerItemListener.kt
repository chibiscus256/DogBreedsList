package com.example.dogbreedslist.ui.base

import com.example.dogbreedslist.data.network.dto.Breed

/**
 * Created by AhmedEltaher
 */

interface RecyclerItemListener {
    fun onItemSelected(item: Breed)
}
