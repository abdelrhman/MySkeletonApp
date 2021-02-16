package com.abdelrahman.myskeletonapp.features.plantdetails

import com.abdelrahman.myskeletonapp.data.repository.PlantRepository
import com.abdelrahman.myskeletonapp.extensions.CoroutineTestExtension
import com.abdelrahman.myskeletonapp.extensions.InstantExecutorExtension
import com.abdelrahman.myskeletonapp.utils.getOrAwaitValue
import com.abdelrahman.myskeletonapp.utils.testPlant
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
class PlantDetailViewModelTest {

    private val plantsRepository = mockk<PlantRepository>()

    @Test
    fun `it should call getPlant with the correct plant id`() {
        val plantId = "1"
        every { plantsRepository.getPlant(plantId) } returns flowOf(testPlant)
        val viewModel = PlantDetailViewModel(plantsRepository, plantId)
        assertThat(viewModel.plant.getOrAwaitValue(), equalTo(testPlant))
    }
}
