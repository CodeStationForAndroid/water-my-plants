package com.abaferastech.watermyplants.domain

import com.abaferastech.watermyplants.data.model.SpeciesListDto
import com.abaferastech.watermyplants.data.remote.ApiResponse
import com.abaferastech.watermyplants.data.remote.SpeciesListParam
import com.abaferastech.watermyplants.domain.model.TodoDetails
import kotlinx.coroutines.flow.Flow

interface PlantApiClient {

    suspend fun getSpeciesList(speciesListParam: SpeciesListParam?): Flow<ApiResponse<SpeciesListDto>>
    suspend fun getPlantsDetails(id: String): Flow<ApiResponse<TodoDetails>>
}