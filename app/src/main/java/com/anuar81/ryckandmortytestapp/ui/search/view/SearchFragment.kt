package com.anuar81.ryckandmortytestapp.ui.search.view

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.anuar81.ryckandmortytestapp.R
import com.anuar81.ryckandmortytestapp.core.base.BaseFragment
import com.anuar81.ryckandmortytestapp.core.delegates.viewBinding
import com.anuar81.ryckandmortytestapp.core.extensions.observe
import com.anuar81.ryckandmortytestapp.databinding.FragmentSearchBinding
import com.anuar81.ryckandmortytestapp.domain.character.CharacterData
import com.anuar81.ryckandmortytestapp.ui.search.adapter.SearchAdapter
import com.anuar81.ryckandmortytestapp.ui.search.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment :
    BaseFragment<FragmentSearchBinding, SearchViewModel>(R.layout.fragment_search),
    SearchAdapter.CharacterObserver {

    override val binding: FragmentSearchBinding by viewBinding(FragmentSearchBinding::bind)
    override val viewModel: SearchViewModel by viewModels()

    private lateinit var adapter: SearchAdapter

    override fun setUp(arguments: Bundle?) {
        super.setUp(arguments)
        viewModel.setUp()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(getString(R.string.fragment_search_title))
        setupRecycler()
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(nameSearch: String?): Boolean {
                viewModel.checkNotEmptyOrNullSearch(nameSearch)
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })
    }

    override fun addViewModelObservables() = with(viewModel) {
        observe(characterSearchList) { updateAdapter(it) }
        observe(showError) { showToast(getString(R.string.search_retur_nothing)) }
        observe(isValidSearch) { viewModel.searchCharacterByName(it) }
        observe(searchIsNullOrEmpty) { showToast(getString(R.string.search_error)) }
    }

    private fun setupRecycler() {
        adapter = SearchAdapter(this)
        binding.recyclerSearch.layoutManager = LinearLayoutManager(context)
        binding.recyclerSearch.adapter = adapter
    }

    private fun updateAdapter(characterList: List<CharacterData>) {
        adapter.characterList = characterList
        adapter.notifyDataSetChanged()
    }

    override fun characterListener(character: CharacterData) {

    }
}
