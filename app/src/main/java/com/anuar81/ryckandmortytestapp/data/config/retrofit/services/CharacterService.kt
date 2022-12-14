package com.anuar81.ryckandmortytestapp.data.config.retrofit.services

import com.anuar81.ryckandmortytestapp.data.config.retrofit.utils.Constants.END_POINT
import com.anuar81.ryckandmortytestapp.data.config.retrofit.utils.Constants.PAGE
import com.anuar81.ryckandmortytestapp.data.config.retrofit.utils.Constants.SEARCH_NAME
import com.anuar81.ryckandmortytestapp.domain.character.CharacterResult
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {
    @GET(END_POINT)
    suspend fun getCharacters(@Query(PAGE) query: Int) : CharacterResult

    @GET(END_POINT)
    suspend fun searchCharacterByName(@Query(SEARCH_NAME) query: String) : CharacterResult
}
