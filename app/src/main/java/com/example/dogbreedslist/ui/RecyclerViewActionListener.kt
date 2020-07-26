package com.example.dogbreedslist.ui

import android.view.View

/*
 * Created by Rifqi Mulya Fahmi on 22/02/18.
 */

interface RecyclerViewActionListener<V> {
    fun onItemClick(v: V)
}

interface RecyclerViewActionListenerWithAnimation<V> {
    fun onItemClick(v: V, itemView: View)
}