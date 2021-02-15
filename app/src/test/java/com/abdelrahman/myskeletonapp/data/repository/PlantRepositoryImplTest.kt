package com.abdelrahman.myskeletonapp.data.repository

import com.abdelrahman.myskeletonapp.data.local.database.dao.PlantDao
import com.abdelrahman.myskeletonapp.data.local.model.Plant
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.collect
import org.junit.jupiter.api.Assertions.*
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class PlantRepositoryImplTest {

    private val plantDao = mockk<PlantDao>()

    val testPlants = arrayListOf(
        Plant("1", "Apple", "A red fruit", 1),
        Plant("2", "B", "Description B", 1),
        Plant("3", "C", "Description C", 2)
    )

    private val plantRepositoryImpl = PlantRepositoryImpl(plantDao)

    @Test
    fun `it should return a flow of plants`() = runBlocking {
        every { plantDao.getPlants() } returns flowOf(testPlants)
        plantRepositoryImpl.getPlants().collect {
            assertEquals(testPlants, it)
        }
    }
}