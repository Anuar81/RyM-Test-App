package com.anuar81.ryckandmortytestapp.usecases

import com.anuar81.ryckandmortytestapp.data.repository.HomeRepository
import com.anuar81.ryckandmortytestapp.domain.character.CharacterData
import javax.inject.Inject

class CharacterListUseCase @Inject constructor(private val homeRepository: HomeRepository) {
    suspend operator fun invoke() : List<CharacterData> {
        return homeRepository.getCharacterList()
    }
}
