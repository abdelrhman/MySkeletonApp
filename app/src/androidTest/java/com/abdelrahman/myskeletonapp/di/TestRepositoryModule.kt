package com.abdelrahman.myskeletonapp.di

import com.abdelrahman.myskeletonapp.data.repository.PlantRepository
import com.abdelrahman.myskeletonapp.fake.FakePlantsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RepositoryModule::class]
)
abstract class TestRepositoryModule {
    @Singleton
    @Binds
    abstract fun bindRepository(repo: FakePlantsRepository): PlantRepository
}
