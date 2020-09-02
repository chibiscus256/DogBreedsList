package com.example.dogbreedslist.ui.breeds

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.network.dto.Breed
import com.example.dogbreedslist.databinding.FragmentBreedlistBinding
import com.example.dogbreedslist.ui.breeds.adapters.BreedAdapter
import com.example.dogbreedslist.utils.autoCleared
import com.example.dogbreedslist.utils.observe
import com.example.dogbreedslist.utils.toGone
import com.example.dogbreedslist.utils.toVisible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Error

@AndroidEntryPoint
class BreedListFragment : Fragment() {

    private val breedListViewModel: BreedListViewModel by activityViewModels()
    var binding: FragmentBreedlistBinding by autoCleared()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreedlistBinding.inflate(
            inflater,
            container,
            false
        )
        context ?: return binding.root
        observe(breedListViewModel.breedsResponse, ::handleList)
        activity?.bottom_nav?.toVisible()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext())
        binding.breedList.layoutManager = layoutManager
        breedListViewModel.getBreeds()
    }

    fun bindListData(breedsResponse: List<Breed>) {
        if (!breedsResponse.isNullOrEmpty()) {
            val breedsAdapter = BreedAdapter(breedsResponse)
            binding.breedList.adapter = breedsAdapter
            showDataView(true)
        } else {
            showDataView(false)
        }
    }

    internal fun showLoadingView() {
        binding.pbLoading.toVisible()
        binding.tvNoData.toGone()
        binding.clBreedList.toGone()
    }

    private fun showDataView(show: Boolean) {
        binding.pbLoading.toGone()
        binding.clBreedList.visibility = if (show) VISIBLE else GONE
        binding.tvNoData.visibility = if (show) GONE else VISIBLE
    }

    private fun handleList(breedsResponse: Resource<List<Breed>>) {
        when (breedsResponse) {
            is Resource.Loading -> showLoadingView()
            is Resource.Success -> breedsResponse.data?.let { bindListData(breedsResponse = it) }
            is Resource.DataError -> showDataView(false)
        }
    }

    override fun onDetach() {
        super.onDetach()
        Log.i(ContentValues.TAG, "aaaaa")
    }
}
