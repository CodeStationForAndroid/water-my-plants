package com.abaferastech.watermyplants.di

import android.content.Context
import androidx.room.Room
import com.abaferastech.watermyplants.data.local.PlantDao
import com.abaferastech.watermyplants.data.local.PlantDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideLocalDatabase(@ApplicationContext context: Context): PlantDatabase {
        return Room.databaseBuilder(
            context, PlantDatabase::class.java, name = "PLANT_DATABASE"
        ).build()
    }

    @Singleton
    @Provides
    fun providePlantDao(database: PlantDatabase): PlantDao {
        return database.plantDao
    }

    @Singleton
    @Provides
    fun provideDatabaseDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}
