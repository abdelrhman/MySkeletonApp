package com.abdelrahman.myskeletonapp.features.plantslist

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.abdelrahman.myskeletonapp.R
import com.abdelrahman.myskeletonapp.data.repository.PlantRepository
import com.abdelrahman.myskeletonapp.di.RepositoryModule
import com.abdelrahman.myskeletonapp.testutilities.launchFragmentInHiltContainer
import com.abdelrahman.myskeletonapp.utils.testPlant
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@MediumTest
@RunWith(AndroidJUnit4::class)
@UninstallModules(RepositoryModule::class)
@HiltAndroidTest
class PlantsListFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var repository: PlantRepository

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun plantsList_displayInUI() {
        // Given
        val navController: NavController = mockk(relaxed = true)
        launchFragmentInHiltContainer<PlantsListFragment>(null, R.style.Theme_Sunflower) {
            Navigation.setViewNavController(view!!, navController)
        }
        onView(withId(R.id.plant_list))
            .perform(
                RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                    hasDescendant(withText(testPlant.name)), click()
                )
            )
        verify {
            navController.navigate(
                PlantsListFragmentDirections.actionViewPagerFragmentToPlantDetailFragment(testPlant.plantId)
            )
        }
    }
}