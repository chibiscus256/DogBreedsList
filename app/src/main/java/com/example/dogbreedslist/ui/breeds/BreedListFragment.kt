package com.example.dogbreedslist.ui.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogbreedslist.data.Resource
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

    private val breedListViewModel: BreedListViewModel by activityViewModels()

    var binding: FragmentBreedlistBinding by autoCleared()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreedlistBinding.inflate(inflater, container, false)
        context ?: return binding.root
        setHasOptionsMenu(true)
        observe(breedListViewModel.breedsResponse, ::handleList)
        return binding.root
    }

    private fun showLoadingView() {
        binding.pbLoading.toVisible()
        binding.clBreedList.toGone()
    }

    private fun showDataView(show: Boolean) {
        binding.clBreedList.visibility = if (show) View.VISIBLE else View.GONE
        binding.pbLoading.toGone()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(requireContext())
        binding.breedList.layoutManager = layoutManager
        binding.lifecycleOwner = viewLifecycleOwner
        breedListViewModel.getBreeds()
    }

    private fun bindListData(breedsResponse: BreedsResponse) {
        if (!(breedsResponse.breeds.isNullOrEmpty())) {
            val breedsAdapter = BreedAdapter(breedListViewModel, breedsResponse.breeds)
            binding.breedList.adapter = breedsAdapter
            showDataView(true)
        } else {
            showDataView(false)
        }
    }


    private fun handleList(breedsResponse: Resource<BreedsResponse>) {
        when (breedsResponse) {
            is Resource.Loading -> showLoadingView()
            is Resource.Success -> breedsResponse.data?.let { bindListData(breedsResponse = it) }
        }
    }

}
