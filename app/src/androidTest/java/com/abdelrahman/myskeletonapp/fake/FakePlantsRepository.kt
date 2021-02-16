package com.abdelrahman.myskeletonapp.fake

import com.abdelrahman.myskeletonapp.data.local.model.Plant
import com.abdelrahman.myskeletonapp.data.repository.PlantRepository
import com.abdelrahman.myskeletonapp.utils.testPlants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class FakePlantsRepository @Inject constructor() : PlantRepository {
    override fun getPlants(): Flow<List<Plant>> {
        return flowOf(testPlants)
    }

    override fun getPlant(plantId: String): Flow<Plant> {
        return flowOf(testPlants.find { it.plantId == plantId }!!)
    }

    override fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): Flow<List<Plant>> {
        return flowOf(testPlants.filter { it.growZoneNumber == growZoneNumber })
    }
}