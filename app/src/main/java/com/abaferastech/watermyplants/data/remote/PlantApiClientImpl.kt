package com.abaferastech.watermyplants.data.remote

import com.abaferastech.watermyplants.data.toDomain
import com.abaferastech.watermyplants.domain.PlantApiClient
import com.abaferastech.watermyplants.domain.model.Todo
import com.abaferastech.watermyplants.domain.model.TodoDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PlantApiClientImpl @Inject constructor(private val api: PlantApiService) :
    PlantApiClient {

    override suspend fun getPlants() : ApiResponse<Flow<List<Todo>>> {
        return try {
            ApiResponse.Success(api.getPlants().map {
                it.map { todoDto ->
                    todoDto.toDomain()
                }
            })
        } catch (io: IOException) {
            ApiResponse.Error(io)
        } catch (httpEx: HttpException){
            ApiResponse.Error(httpEx)
        }
    }



    override suspend fun getPlantsDetails(id: String): ApiResponse<Flow<TodoDetails>> {
        return try {
            ApiResponse.Success(api.getPlantDetails(id = id).map {
                it.toDomain()
            })
        } catch (io: IOException) {
            ApiResponse.Error(io)
        } catch (httpEx: HttpException){
            ApiResponse.Error(httpEx)
        }
    }

}
