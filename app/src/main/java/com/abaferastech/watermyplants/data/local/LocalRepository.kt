package com.abaferastech.watermyplants.data.local

import com.abaferastech.watermyplants.data.local.Plant
import kotlinx.coroutines.flow.Flow

interface LocalRepository {

    fun getPlantEntities(): Flow<List<Plant>>

    suspend fun getPlantEntityById(id: Int): Plant?

    suspend fun insertPlantEntity(plant: Plant)

    suspend fun deletePlantEntity(plant: Plant)

}