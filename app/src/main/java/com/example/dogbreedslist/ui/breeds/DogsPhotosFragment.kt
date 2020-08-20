package com.example.dogbreedslist.ui.breeds

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DogsPhotosFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onResume() {
        super.onResume()
        Log.i(ContentValues.TAG, "photos onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i(ContentValues.TAG, "photos onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.i(ContentValues.TAG, "photos onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.i(ContentValues.TAG, "photos onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(ContentValues.TAG, "photos onDestroy")

    }
}