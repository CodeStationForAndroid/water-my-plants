package com.abaferastech.watermyplants.data.remote

import com.abaferastech.watermyplants.data.TodoDetailsDto
import com.abaferastech.watermyplants.data.TodoDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface PlantApiService {

    @GET("/species-list")
    suspend fun getPlants() : Flow<List<TodoDto>>

    @GET("/species/details/{id}")
    suspend fun getPlantDetails(@Path("id") id: String): Flow<List<TodoDetailsDto>>
}