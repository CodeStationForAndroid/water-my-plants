package com.abaferastech.watermyplants.domain

import com.abaferastech.watermyplants.data.remote.ApiResponse
import com.abaferastech.watermyplants.domain.model.Todo
import com.abaferastech.watermyplants.domain.model.TodoDetails
import kotlinx.coroutines.flow.Flow

interface PlantApiClient {

    suspend fun getPlants(): ApiResponse<Flow<List<Todo>>>
    suspend fun getPlantsDetails(id: String): ApiResponse<Flow<TodoDetails>>
}