package com.anuar81.ryckandmortytestapp.data.repository

import com.anuar81.ryckandmortytestapp.data.config.retrofit.result.NetworkResult
import com.anuar81.ryckandmortytestapp.data.datasource.CharacterDataSource
import com.anuar81.ryckandmortytestapp.domain.character.CharacterData
import javax.inject.Inject

class SearchRepository @Inject constructor(private val characterDataSource: CharacterDataSource) {
    suspend fun searchCharacterByName(name: String): List<CharacterData> {
        return when (val networkResponse = characterDataSource.searchCharacterByName(name)) {
            is NetworkResult.OnSuccess -> {
                networkResponse.value
            }
            is NetworkResult.OnFailure -> {
                emptyList()
            }
        }
    }
}
