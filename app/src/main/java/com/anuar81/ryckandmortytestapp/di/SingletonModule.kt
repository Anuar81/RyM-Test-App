package com.anuar81.ryckandmortytestapp.di

import com.anuar81.ryckandmortytestapp.data.config.retrofit.adapters.CharacterAdapter
import com.anuar81.ryckandmortytestapp.data.config.retrofit.services.CharacterService
import com.anuar81.ryckandmortytestapp.data.datasource.CharacterDataSource
import com.anuar81.ryckandmortytestapp.data.repository.HomeRepository
import com.anuar81.ryckandmortytestapp.data.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SingletonModule {

    @Provides
    @Singleton
    fun providesHomeRepository(characterDataSource: CharacterDataSource) : HomeRepository {
        return HomeRepository(characterDataSource)
    }

    @Provides
    @Singleton
    fun providesSearchRepository(characterDataSource: CharacterDataSource) : SearchRepository {
        return SearchRepository(characterDataSource)
    }

    @Provides
    @Singleton
    fun providesCharacterDataSource(characterService: CharacterService) : CharacterDataSource {
        return CharacterAdapter(characterService)
    }
}
