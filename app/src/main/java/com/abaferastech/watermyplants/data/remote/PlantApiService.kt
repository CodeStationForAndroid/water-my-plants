package com.abaferastech.watermyplants.data.remote

import com.abaferastech.watermyplants.data.TodoDetailsDto
import com.abaferastech.watermyplants.data.model.SpeciesListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PlantApiService {

    @GET("species-list")
    suspend fun getSpeciesList(
        @Query("page") page: Int? = 1,
        @Query("q") q: String? = null,
        @Query("order") order: Order?,
        @Query("edible") edible: Int? = null,
        @Query("poisonous") poisonous: Int? = null,
        @Query("cycle") cycle: Cycle? = null,
        @Query("watering") watering: Watering?,
        @Query("sunlight") sunlight: Sunlight?,
        @Query("indoor") indoor: Int? = null,
        @Query("hardiness") hardiness: Int? = null
    ): SpeciesListDto

    @GET("species/details/{id}")
    suspend fun getPlantDetails(@Path("id") id: String): TodoDetailsDto
}