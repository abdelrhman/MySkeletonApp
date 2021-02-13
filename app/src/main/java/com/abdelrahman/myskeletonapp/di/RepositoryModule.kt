package com.abdelrahman.myskeletonapp.di

import com.abdelrahman.myskeletonapp.data.local.database.dao.PlantDao
import com.abdelrahman.myskeletonapp.data.repository.PlantRepository
import com.abdelrahman.myskeletonapp.data.repository.PlantRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providePlantRepository(plantDao: PlantDao): PlantRepository {
        return PlantRepositoryImpl(plantDao)
    }
}