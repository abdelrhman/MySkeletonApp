package com.abdelrahman.myskeletonapp.data.local.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.Calendar

class PlantTest {

    private lateinit var plant: Plant

    @BeforeEach
    fun setUp() {
        plant = Plant("1", "Tomato", "A red vegetable", 1, 2, "")
    }

    @Test
    fun `test default values`() {
        val defaultPlant = Plant("2", "Apple", "Description", 1)
        assertEquals(7, defaultPlant.wateringInterval)
        assertEquals("", defaultPlant.imageUrl)
    }

    @Test
    fun `test should be watered`() {
        Calendar.getInstance().let { now ->
            // Generate lastWateringDate from being as copy of now.
            val lastWateringDate = Calendar.getInstance()

            // Test for lastWateringDate is today.
            lastWateringDate.time = now.time
            assertFalse(plant.shouldBeWatered(now, lastWateringDate.apply { add(Calendar.DAY_OF_YEAR, -0) }))

            // Test for lastWateringDate is yesterday.
            lastWateringDate.time = now.time
            assertFalse(plant.shouldBeWatered(now, lastWateringDate.apply { add(Calendar.DAY_OF_YEAR, -1) }))

            // Test for lastWateringDate is the day before yesterday.
            lastWateringDate.time = now.time
            assertFalse(plant.shouldBeWatered(now, lastWateringDate.apply { add(Calendar.DAY_OF_YEAR, -2) }))

            // Test for lastWateringDate is some days ago, three days ago, four days ago etc.
            lastWateringDate.time = now.time
            assertTrue(plant.shouldBeWatered(now, lastWateringDate.apply { add(Calendar.DAY_OF_YEAR, -3) }))
        }
    }

    @Test
    fun `test to string`() {
        assertEquals("Tomato", plant.toString())
    }
}