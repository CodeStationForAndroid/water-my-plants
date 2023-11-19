package com.abaferastech.watermyplants.domain.use_case

import com.abaferastech.watermyplants.data.toDomain
import com.abaferastech.watermyplants.domain.PlantApiClient
import com.abaferastech.watermyplants.domain.model.Todo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class getAllPlantsImpl(private val plantApiClient: PlantApiClient) : getAllPlants {
    override suspend fun invoke(): Flow<List<Todo>> {
       return plantApiClient.getPlants().map { it.map { todoDto -> todoDto.toDomain() } }
    }
}