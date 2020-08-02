package com.example.dogbreedslist.breeds

import android.app.Activity
import android.os.Bundle
import com.example.dogbreedslist.App

class BreedListActivity : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App)
        super.onCreate(savedInstanceState)
    }
}