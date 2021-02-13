package com.abdelrahman.myskeletonapp.data.local.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.Calendar

class GardenPlantingTest {
    @Test
    fun testDefaultValues() {
        val gardenPlanting = GardenPlanting("1")
        val cal = Calendar.getInstance()
        assertYMD(cal, gardenPlanting.plantDate)
        assertYMD(cal, gardenPlanting.lastWateringDate)
        assertEquals(0L, gardenPlanting.gardenPlantingId)
    }

    // Only Year/Month/Day precision is needed for comparing GardenPlanting Calendar entries
    private fun assertYMD(expectedCal: Calendar, actualCal: Calendar) {
        assertEquals(actualCal.get(Calendar.YEAR), expectedCal.get(Calendar.YEAR))
        assertEquals(actualCal.get(Calendar.MONTH), expectedCal.get(Calendar.MONTH))
        assertEquals(actualCal.get(Calendar.DAY_OF_MONTH), expectedCal.get(Calendar.DAY_OF_MONTH))
    }
}