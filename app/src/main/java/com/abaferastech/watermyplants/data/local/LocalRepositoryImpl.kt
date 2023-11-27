package com.abaferastech.watermyplants.data.local

import kotlinx.coroutines.flow.Flow

class LocalRepositoryImpl(
    private val dao: PlantDao
): LocalRepository {
    override fun getPlantEntities(): Flow<List<Plant>> {
        return dao.getPlants()
    }

    override suspend fun getPlantEntityById(id: Int): Plant? {
        return dao.getPlantById(id)
    }

    override suspend fun insertPlantEntity(plant: Plant) {
        dao.insertPlant(plant)
    }

    override suspend fun deletePlantEntity(plant: Plant) {
        dao.deletePlant(plant)
    }

}