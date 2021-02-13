package com.abdelrahman.myskeletonapp.testutilities

import com.abdelrahman.myskeletonapp.data.local.model.GardenPlanting
import com.abdelrahman.myskeletonapp.data.local.model.Plant
import java.util.Calendar

/**
 * [Plant] objects used for tests.
 */
val testPlants = arrayListOf(
    Plant("1", "Apple", "A red fruit", 1),
    Plant("2", "B", "Description B", 1),
    Plant("3", "C", "Description C", 2)
)
val testPlant = testPlants[0]

/**
 * [Calendar] object used for tests.
 */
val testCalendar: Calendar = Calendar.getInstance().apply {
    set(Calendar.YEAR, 1998)
    set(Calendar.MONTH, Calendar.SEPTEMBER)
    set(Calendar.DAY_OF_MONTH, 4)
}

val testGardenPlanting = GardenPlanting(testPlant.plantId, testCalendar, testCalendar)