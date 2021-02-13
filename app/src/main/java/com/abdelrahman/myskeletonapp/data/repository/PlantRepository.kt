package com.abdelrahman.myskeletonapp.data.repository

import com.abdelrahman.myskeletonapp.data.local.database.dao.PlantDao
import com.abdelrahman.myskeletonapp.data.local.model.Plant
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository module for handling data operations.
 *
 * Collecting from the Flows in [PlantDao] is main-safe.  Room supports Coroutines and moves the
 * query execution off of the main thread.
 */
@Singleton
class PlantRepositoryImpl @Inject constructor(private val plantDao: PlantDao) : PlantRepository {

    override fun getPlants() = plantDao.getPlants()

    override fun getPlant(plantId: String) = plantDao.getPlant(plantId)

    override fun getPlantsWithGrowZoneNumber(growZoneNumber: Int) =
        plantDao.getPlantsWithGrowZoneNumber(growZoneNumber)
}

interface PlantRepository {

    fun getPlants(): Flow<List<Plant>>

    fun getPlant(plantId: String): Flow<Plant>

    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): Flow<List<Plant>>
}
