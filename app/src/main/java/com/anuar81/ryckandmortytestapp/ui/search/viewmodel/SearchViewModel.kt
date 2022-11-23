package com.anuar81.ryckandmortytestapp.ui.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.anuar81.ryckandmortytestapp.core.base.BaseViewModel
import com.anuar81.ryckandmortytestapp.domain.character.CharacterData
import com.anuar81.ryckandmortytestapp.usecases.SearchCharacterByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val searchCharacterByNameUseCase: SearchCharacterByNameUseCase) :
    BaseViewModel() {

    private val _characterSearchList = MutableLiveData<List<CharacterData>>()
    val characterSearchList: LiveData<List<CharacterData>> get() = _characterSearchList
    private val _searchIsNullOrEmpty = MutableLiveData<Unit>()
    val searchIsNullOrEmpty: LiveData<Unit> get() = _searchIsNullOrEmpty
    private val _isValidSearch = MutableLiveData<String>()
    val isValidSearch: LiveData<String> get() = _isValidSearch

    override fun setUp() {
        super.setUp()
    }

    fun searchCharacterByName(name: String) {
        viewModelScope.launch {
            val response = searchCharacterByNameUseCase(name)
            launch(Dispatchers.Main) {
                if (response.isEmpty()) {
                    _showError.value = Unit
                }
                _characterSearchList.value = response
            }
        }
    }

    fun checkNotEmptyOrNullSearch(searchString: String?) =
        if (!searchString.isNullOrBlank()) {
            searchString.let { _isValidSearch.value = it }
        } else {
            _searchIsNullOrEmpty.value = Unit
        }
}
