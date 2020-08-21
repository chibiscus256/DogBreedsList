package com.example.dogbreedslist.ui.breeds

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogbreedslist.R
import com.example.dogbreedslist.databinding.FragmentBreedlistBinding
import com.example.dogbreedslist.ui.breeds.breedadapter.SubBreedAdapter
import com.example.dogbreedslist.utils.TransferUtils
import com.example.dogbreedslist.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList

@AndroidEntryPoint
class SubbreedsListFragment : Fragment() {

    var binding: FragmentBreedlistBinding by autoCleared()
    lateinit var breedListViewModel: BreedListViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "subbreeds onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "subbreeds onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "subbreeds onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "subbreeds onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "subbreeds onDestroy")
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_breedlist,
            container,
            false
        )
        context ?: return binding.root
        breedListViewModel = ViewModelProvider(this).get(BreedListViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val args = arguments?.getStringArray("subbreeds")
        val list= args?.toList()
        val layoutManager = LinearLayoutManager(requireContext())
        binding.breedList.layoutManager = layoutManager
        val breedsAdapter = SubBreedAdapter(breedListViewModel, list as List<String>)
        binding.breedList.adapter = breedsAdapter
    }

}