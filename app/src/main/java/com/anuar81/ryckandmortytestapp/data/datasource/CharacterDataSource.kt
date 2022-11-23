package com.anuar81.ryckandmortytestapp.data.datasource

import com.anuar81.ryckandmortytestapp.data.config.retrofit.result.NetworkResult
import com.anuar81.ryckandmortytestapp.domain.character.CharacterData

interface CharacterDataSource {
    suspend fun getCharacterList() : NetworkResult<List<CharacterData>>
}
