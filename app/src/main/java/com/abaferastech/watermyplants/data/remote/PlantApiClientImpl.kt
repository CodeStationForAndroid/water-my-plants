package com.abaferastech.watermyplants.data.remote

import com.abaferastech.watermyplants.domain.PlantApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PlantApiClientImpl @Inject constructor(private val api: PlantApiService) :
    PlantApiClient {

    override suspend fun getSpeciesList(speciesListParam: SpeciesListParam?) = flow {
        emit(ApiResponse.Loading)
        val result = api.getSpeciesList(
            page = speciesListParam?.page,
            q = speciesListParam?.q,
            order = speciesListParam?.order,
            edible = speciesListParam?.edible,
            poisonous = speciesListParam?.poisonous,
            cycle = speciesListParam?.cycle,
            watering = speciesListParam?.watering,
            sunlight = speciesListParam?.sunlight,
            indoor = speciesListParam?.indoor,
            hardiness = speciesListParam?.hardiness
        )

        emit(ApiResponse.Success(result))
    }.catch {
        emit(ApiResponse.Error(Exception(it)))
    }.flowOn(Dispatchers.IO)


    override suspend fun getPlantsDetails(id: String) = TODO()

}
