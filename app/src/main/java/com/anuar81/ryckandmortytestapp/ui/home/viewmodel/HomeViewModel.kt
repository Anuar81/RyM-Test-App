package com.anuar81.ryckandmortytestapp.ui.home.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.anuar81.ryckandmortytestapp.R
import com.anuar81.ryckandmortytestapp.core.base.BaseViewModel
import com.anuar81.ryckandmortytestapp.domain.character.CharacterData
import com.anuar81.ryckandmortytestapp.domain.core.nav.NavModel
import com.anuar81.ryckandmortytestapp.usecases.CharacterListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val characterListUseCase: CharacterListUseCase) :
    BaseViewModel() {

    private val _characterList = MutableLiveData<List<CharacterData>>()
    val characterList : LiveData<List<CharacterData>> get() = _characterList

    override fun setUp() {
        super.setUp()
        getCharacterList()
    }

    fun navigatesToSearch() {
        _navigateTo.value = NavModel(R.id.action_homeFragment_to_searchFragment)
    }

    private fun getCharacterList() {
        viewModelScope.launch {
            val response = characterListUseCase()
            launch(Dispatchers.Main) {
                if (response.isEmpty()) {
                    _showError.value = Unit
                } else {
                    _characterList.value = response
                }
            }
        }
    }
}
