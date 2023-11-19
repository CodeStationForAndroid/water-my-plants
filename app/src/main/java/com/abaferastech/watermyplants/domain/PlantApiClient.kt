package com.abaferastech.watermyplants.domain

import com.abaferastech.watermyplants.data.TodoDetailsDto
import com.abaferastech.watermyplants.data.TodoDto
import kotlinx.coroutines.flow.Flow

interface PlantApiClient {

    suspend fun getPlants(): Flow<List<TodoDto>>
    suspend fun getPlantsDetails(id: String): Flow<List<TodoDetailsDto>>
}