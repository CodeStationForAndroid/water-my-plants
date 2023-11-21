package com.abaferastech.watermyplants.domain.use_case

import com.abaferastech.watermyplants.data.model.SpeciesListDto
import com.abaferastech.watermyplants.data.remote.ApiResponse
import com.abaferastech.watermyplants.data.remote.SpeciesListParam
import com.abaferastech.watermyplants.domain.PlantApiClient
import kotlinx.coroutines.flow.Flow

class UseCaseGetAllPlants(private val plantApiClient: PlantApiClient) {
    suspend operator fun invoke(speciesListParam: SpeciesListParam? = null): Flow<ApiResponse<SpeciesListDto>> {
       return plantApiClient.getSpeciesList(speciesListParam)
    }
}