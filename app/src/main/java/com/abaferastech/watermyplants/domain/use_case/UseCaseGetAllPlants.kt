package com.abaferastech.watermyplants.domain.use_case

import com.abaferastech.watermyplants.data.remote.ApiResponse
import com.abaferastech.watermyplants.domain.PlantApiClient
import com.abaferastech.watermyplants.domain.model.Todo
import kotlinx.coroutines.flow.Flow

class UseCaseGetAllPlants(private val plantApiClient: PlantApiClient) {
    suspend operator fun invoke(): ApiResponse<Flow<List<Todo>>> {
       return plantApiClient.getPlants()
    }
}