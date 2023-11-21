package com.abaferastech.watermyplants.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.abaferastech.watermyplants.domain.PlantApiClient
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class SpecieDtoApiClientImplTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val BASE_URL = "https://perenual.com/api/"
    private val PLANT_API_KEY = "sk-13ed6551ab16cddbb2938"

    private lateinit var retrofit: Retrofit
    private lateinit var plantApiService: PlantApiService
    private lateinit var plantClient: PlantApiClient

    private val logging = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val originalRequest = chain.request()
            val newUrl =
                originalRequest.url.newBuilder().addQueryParameter("key",
                    PLANT_API_KEY
                )
                    .build()
            val newRequest = originalRequest.newBuilder().url(newUrl).build()
            chain.proceed(newRequest)
        }.addInterceptor(logging)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()


    @Before
    fun setUp() {
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        plantApiService = retrofit.create(PlantApiService::class.java)
        plantClient = PlantApiClientImpl(plantApiService)
    }

    @Test
    fun shouldBeTheSameUrl(){
        assertEquals(retrofit.baseUrl().toString(), BASE_URL)
    }

    @Test
    fun shouldReturnSpeciesListDto() {
        runTest {
            val apiResponseFlow = plantClient.getSpeciesList(SpeciesListParam(page = 2))
            apiResponseFlow.collect{ apiResponse ->
                when(apiResponse){
                    is ApiResponse.Error -> fail("Error: ${apiResponse.exception}")
                    ApiResponse.Loading -> println("Loading")
                    is ApiResponse.Success -> {
                        assertTrue(apiResponse.data.total == 10102)
                    }
                }
            }
        }
    }

}