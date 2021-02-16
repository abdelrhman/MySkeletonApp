package com.abdelrahman.myskeletonapp.features.plantdetails

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.abdelrahman.myskeletonapp.R
import com.abdelrahman.myskeletonapp.data.repository.PlantRepository
import com.abdelrahman.myskeletonapp.testutilities.launchFragmentInHiltContainer
import com.abdelrahman.myskeletonapp.utils.testPlant
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@MediumTest
@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class PlantDetailFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var repository: PlantRepository

    @Before
    fun init() {
        // Populate @Inject fields in test class
        hiltRule.inject()
    }

    @Test
    fun plantDetails_displayInUI() {
        // Given
        val plant = testPlant
        // When
        val bundle = PlantDetailFragmentArgs(plantId = plant.plantId).toBundle()
        launchFragmentInHiltContainer<PlantDetailFragment>(bundle, R.style.Theme_Sunflower)
        //
        onView(withId(R.id.plant_detail_name)).check(matches(isDisplayed()))
        onView(withId(R.id.plant_detail_name)).check(matches(withText(plant.name)))

        onView(withId(R.id.plant_watering_header)).check(matches(isDisplayed()))

        onView(withId(R.id.plant_watering)).check(matches(isDisplayed()))
        onView(withId(R.id.plant_watering)).check(matches(withText("every ${plant.wateringInterval} days")))

        onView(withId(R.id.plant_description)).check(matches(isDisplayed()))
        onView(withId(R.id.plant_description)).check(matches(withText(plant.description)))
    }
}
