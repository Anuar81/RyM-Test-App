package com.anuar81.ryckandmortytestapp.ui.home.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.anuar81.ryckandmortytestapp.R
import com.anuar81.ryckandmortytestapp.core.base.BaseFragment
import com.anuar81.ryckandmortytestapp.core.delegates.viewBinding
import com.anuar81.ryckandmortytestapp.core.extensions.observe
import com.anuar81.ryckandmortytestapp.databinding.FragmentHomeBinding
import com.anuar81.ryckandmortytestapp.domain.character.CharacterData
import com.anuar81.ryckandmortytestapp.ui.home.adapter.HomeAdapter
import com.anuar81.ryckandmortytestapp.ui.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home), HomeAdapter.CharacterObserver {

    override val binding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel: HomeViewModel by viewModels()

    private lateinit var adapter: HomeAdapter

    override fun setUp(arguments: Bundle?) {
        super.setUp(arguments)
        viewModel.setUp()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
    }

    override fun addViewModelObservables() = with(viewModel) {
        observe(showError) {
            // TODO: show error on view 
        }
        observe(characterList) {
            adapter.characterList = it
            adapter.notifyDataSetChanged()
        }
    }

    private fun setupRecycler() {
        adapter = HomeAdapter(this)
        binding.recyclerHome.layoutManager = LinearLayoutManager(context)
        binding.recyclerHome.adapter = adapter
    }

    override fun itemListener(character: CharacterData) {
        TODO("Not yet implemented")
    }


}
