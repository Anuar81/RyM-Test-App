package com.anuar81.ryckandmortytestapp.data.repository

import com.anuar81.ryckandmortytestapp.data.config.retrofit.result.NetworkResult
import com.anuar81.ryckandmortytestapp.data.datasource.CharacterDataSource
import com.anuar81.ryckandmortytestapp.domain.character.CharacterData
import javax.inject.Inject

class HomeRepository @Inject constructor(private val characterDataSource: CharacterDataSource) {
    suspend fun getCharacterList() : List<CharacterData> {
        return when (val networkResponse = characterDataSource.getCharacterList()){
            is NetworkResult.OnSuccess -> {
                networkResponse.value
                // TODO: save or update on database
            }
            is NetworkResult.OnFailure -> {
                emptyList()
                // TODO: read from database backup
            }
        }
    }
}
