package com.abaferastech.watermyplants.data.remote

import com.abaferastech.watermyplants.domain.PlantApiClient
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class PlantApiClientImplTest {

    val BASE_URL = "https://perenual.com/api/"
    val PLANT_API_KEY = "sk-13ed6551ab16cddbb2938"

    lateinit var retrofit: Retrofit
    lateinit var plantApiService: PlantApiService
    lateinit var plantClient: PlantApiClient


    val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val originalRequest = chain.request()
            val newUrl =
                originalRequest.url.newBuilder().addQueryParameter("key",
                    PLANT_API_KEY
                )
                    .build()
            val newRequest = originalRequest.newBuilder().url(newUrl).build()
            chain.proceed(newRequest)
        }.connectTimeout(60, TimeUnit.SECONDS)
        .build()


    @Before
    fun setUp() {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        plantApiService = retrofit.create(PlantApiService::class.java)
        plantClient = PlantApiClientImpl(plantApiService)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getPlants() {
        runBlocking {
            val result =  plantClient.getPlants()
        }


    }
}