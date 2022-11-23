package com.anuar81.ryckandmortytestapp.data.config.retrofit.adapters

import com.anuar81.ryckandmortytestapp.data.config.retrofit.result.NetworkResult
import com.anuar81.ryckandmortytestapp.data.config.retrofit.services.CharacterService
import com.anuar81.ryckandmortytestapp.data.datasource.CharacterDataSource
import com.anuar81.ryckandmortytestapp.domain.character.CharacterData
import javax.inject.Inject

class CharacterAdapter @Inject constructor(
    private val characterService: CharacterService
) : CharacterDataSource {
    override suspend fun getCharacterList(): NetworkResult<List<CharacterData>> {
        return try {
            val response = characterService.getCharacters(1)
            return NetworkResult.OnSuccess(response.results)
        } catch(e: Exception) {
            NetworkResult.OnFailure(e)
        }
    }
}
