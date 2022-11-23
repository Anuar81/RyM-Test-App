package com.anuar81.ryckandmortytestapp.usecases

import com.anuar81.ryckandmortytestapp.data.repository.SearchRepository
import com.anuar81.ryckandmortytestapp.domain.character.CharacterData
import javax.inject.Inject

class SearchCharacterByNameUseCase @Inject constructor(private val searchRepository: SearchRepository) {
    suspend operator fun invoke(name: String): List<CharacterData> {
        return searchRepository.searchCharacterByName(name)
    }
}
