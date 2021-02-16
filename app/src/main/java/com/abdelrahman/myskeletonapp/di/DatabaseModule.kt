package com.abdelrahman.myskeletonapp.di

import android.content.Context
import com.abdelrahman.myskeletonapp.data.local.database.AppDatabase
import com.abdelrahman.myskeletonapp.data.local.database.dao.PlantDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun providePlantDao(appDatabase: AppDatabase): PlantDao {
        return appDatabase.plantDao()
    }
}
