package com.abaferastech.watermyplants.data.remote

import com.abaferastech.watermyplants.domain.PlantApiClient
import javax.inject.Inject

class PlantApiClientImpl @Inject constructor(private val api: PlantApiService) :
    PlantApiClient {

    override suspend fun getPlants() = api.getPlants()
    override suspend fun getPlantsDetails(id: String) = api.getPlantDetails(id)

}
