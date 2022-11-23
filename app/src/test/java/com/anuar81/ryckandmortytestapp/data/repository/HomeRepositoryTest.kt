package com.anuar81.ryckandmortytestapp.data.repository

import com.anuar81.ryckandmortytestapp.data.config.retrofit.result.NetworkResult
import com.anuar81.ryckandmortytestapp.data.datasource.CharacterDataSource
import com.anuar81.ryckandmortytestapp.domain.character.CharacterData
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.kotlin.doReturn

class HomeRepositoryTest {
    private lateinit var homeRepository: HomeRepository

    private val characterDataSourceMock: CharacterDataSource = mock(CharacterDataSource::class.java)

    @Mock
    private lateinit var characterDataMock: CharacterData

    @Before
    fun setUp() {
        characterDataMock = CharacterData("testName", "testSpecies", "testImage","testUrl")
        homeRepository = HomeRepository(characterDataSourceMock)
    }

    @Test
    fun networkResultErrorCall() = runBlocking {
        val networkResultError = NetworkResult.OnFailure(Exception())
        `when`(characterDataSourceMock.getCharacterList()) doReturn networkResultError
        val list = homeRepository.getCharacterList()
        assertTrue(list.isEmpty())
    }

    @Test
    fun networkResultSuccessCall() = runBlocking {
        val characterList = listOf<CharacterData>(characterDataMock)
        val networkResultError = NetworkResult.OnSuccess(characterList)
        `when`(characterDataSourceMock.getCharacterList()) doReturn networkResultError
        val list = homeRepository.getCharacterList()
        assertTrue(list.isNotEmpty())
    }
}
