package com.abaferastech.watermyplants.domain.use_case

import com.abaferastech.watermyplants.data.remote.ApiResponse
import com.abaferastech.watermyplants.domain.PlantApiClient
import com.abaferastech.watermyplants.domain.model.TodoDetails
import kotlinx.coroutines.flow.Flow

class UseCaseGetPlantDetails(private val plantApiClient: PlantApiClient){
    suspend operator fun invoke(id: String): ApiResponse<Flow<TodoDetails>> {
        return plantApiClient.getPlantsDetails(id)
    }

}
