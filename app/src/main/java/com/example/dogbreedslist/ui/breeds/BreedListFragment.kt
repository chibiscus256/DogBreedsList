package com.example.dogbreedslist.ui.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogbreedslist.R
import com.example.dogbreedslist.binding.FragmentDataBindingComponent
import com.example.dogbreedslist.data.Resource
import com.example.dogbreedslist.data.local.breeds.BreedData
import com.example.dogbreedslist.data.network.dto.BreedsResponse
import com.example.dogbreedslist.databinding.FragmentBreedlistBinding
import com.example.dogbreedslist.ui.breeds.breedadapter.BreedAdapter
import com.example.dogbreedslist.utils.autoCleared
import com.example.dogbreedslist.utils.observe
import com.example.dogbreedslist.utils.toGone
import com.example.dogbreedslist.utils.toVisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreedListFragment : Fragment() {

    private val breedList  = mutableListOf<BreedData>()
    private val breedListViewModel: BreedListViewModel by activityViewModels()
    var binding: FragmentBreedlistBinding by autoCleared()
    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_breedlist,
            container,
            false,
            dataBindingComponent
        )
        context ?: return binding.root
        observe(breedListViewModel.breedsResponse, ::handleList)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        val layoutManager = LinearLayoutManager(requireContext())
        binding.breedList.layoutManager = layoutManager
        breedListViewModel.getBreeds()
    }

    private fun bindListData(breedsResponse: BreedsResponse) {
        if (breedsResponse.breeds != null) {
            val breedsAdapter = BreedAdapter(breedListViewModel, breedList)
            binding.breedList.adapter = breedsAdapter
            showDataView(true)
        } else {
            showDataView(false)
        }
    }

    private fun showLoadingView() {
        binding.pbLoading.toVisible()
        binding.clBreedList.toGone()
    }

    private fun showDataView(show: Boolean) {
        binding.clBreedList.visibility = if (show) View.VISIBLE else View.GONE
    }

    private fun handleList(breedsResponse: Resource<BreedsResponse>) {
        when (breedsResponse) {
            is Resource.Loading -> showLoadingView()
            is Resource.Success -> breedsResponse.data?.let { bindListData(breedsResponse = it) }
        }
    }
}
