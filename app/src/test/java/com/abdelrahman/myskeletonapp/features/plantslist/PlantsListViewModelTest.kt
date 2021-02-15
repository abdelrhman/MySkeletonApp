package com.abdelrahman.myskeletonapp.features.plantslist

import androidx.lifecycle.SavedStateHandle
import com.abdelrahman.myskeletonapp.data.repository.PlantRepository
import com.abdelrahman.myskeletonapp.extensions.CoroutineTestExtension
import com.abdelrahman.myskeletonapp.extensions.InstantExecutorExtension
import com.abdelrahman.myskeletonapp.utils.getOrAwaitValue
import com.abdelrahman.myskeletonapp.utils.testPlants
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions

@Extensions(
    ExtendWith(CoroutineTestExtension::class),
    ExtendWith(InstantExecutorExtension::class)
)
class PlantsListViewModelTest {

    private val plantsRepository = mockk<PlantRepository>()
    private val savedStateHandle = mockk<SavedStateHandle>(relaxed = true)

    @Test
    fun `Is filtered should be false when there is no grow zone`() {
        every { savedStateHandle.get<Int>("GROW_ZONE_SAVED_STATE_KEY") } returns null
        val viewModel = PlantsListViewModel(plantsRepository, savedStateHandle)
        assertThat(viewModel.isFiltered(), equalTo(false))
    }

    @Test
    fun `Is filtered should be true when there is a grow zone`() {
        every { savedStateHandle.get<Int>("GROW_ZONE_SAVED_STATE_KEY") } returns 7
        val viewModel = PlantsListViewModel(plantsRepository, savedStateHandle)
        assertThat(viewModel.isFiltered(), equalTo(true))
    }

    @Test
    fun `plant calls the correct repository method based on the grow zone filter `() {
        //arrange
        every { savedStateHandle.get<Int>("GROW_ZONE_SAVED_STATE_KEY") } returns -1
        every { plantsRepository.getPlants() } returns flowOf(testPlants)
        val viewModel = PlantsListViewModel(plantsRepository, savedStateHandle)
        //act
        viewModel.clearGrowZoneNumber()
        //assert
        assertThat(viewModel.plants.getOrAwaitValue(), equalTo(testPlants))
        //arrange
        val growZone = 2
        val expected = testPlants.filter { it.growZoneNumber == growZone }
        every { plantsRepository.getPlantsWithGrowZoneNumber(growZone) } returns flowOf(expected)
        //act
        viewModel.setGrowZoneNumber(growZone)
        //assert
        assertThat(viewModel.plants.getOrAwaitValue(), equalTo(expected))
    }
}