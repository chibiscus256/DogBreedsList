package com.example.dogbreedslist.ui.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogbreedslist.R
import com.example.dogbreedslist.databinding.FragmentBreedlistBinding
import com.example.dogbreedslist.ui.breeds.adapters.SubBreedAdapter
import com.example.dogbreedslist.viewmodel.BreedListViewModel
import com.example.dogbreedslist.utils.autoCleared
import com.example.dogbreedslist.utils.setTitle
import com.example.dogbreedslist.utils.toVisible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class SubbreedsListFragment : Fragment() {

    var binding: FragmentBreedlistBinding by autoCleared()
    lateinit var breedListViewModel: BreedListViewModel

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
        activity?.bottom_nav?.toVisible()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        val list = arguments?.getStringArray("subbreeds")?.toList()
        val name = arguments?.getString("breedName").toString()
        setTitle(name.capitalize())
        val layoutManager = LinearLayoutManager(requireContext())
        binding.breedList.layoutManager = layoutManager
        val breedsAdapter = SubBreedAdapter(list as List<String>, name)
        binding.breedList.adapter = breedsAdapter
    }
}