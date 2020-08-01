package com.example.dogbreedslist.breeds

import android.app.Activity
import android.os.Bundle
import com.example.dogbreedslist.DblApp

class BreedsListActivity : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as DblApp)
        super.onCreate(savedInstanceState)
    }
}