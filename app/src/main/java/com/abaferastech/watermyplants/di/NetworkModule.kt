package com.abaferastech.watermyplants.di

import com.abaferastech.watermyplants.data.remote.PlantApiService
import com.abaferastech.watermyplants.data.remote.PlantApiClientImpl
import com.abaferastech.watermyplants.domain.PlantApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://perenual.com/api/"
    private const val PLANT_API_KEY = "sk-13ed6551ab16cddbb2938"
    @Provides
    @Singleton
    fun providesPlantApi() : PlantApiService {
        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val newUrl = originalRequest.url().newBuilder().addQueryParameter("key", PLANT_API_KEY).build()
                val newRequest = originalRequest.newBuilder().url(newUrl).build()
                chain.proceed(newRequest)
            }.connectTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(PlantApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesPlantRemoteRepository(plantApiService: PlantApiService) : PlantApiClient = PlantApiClientImpl(plantApiService)

}