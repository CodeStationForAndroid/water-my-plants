//package com.abaferastech.watermyplants.di
//
//import android.app.Application
//import androidx.room.Room
//import com.abaferastech.watermyplants.data.local.LocalRepository
//import com.abaferastech.watermyplants.data.local.LocalRepositoryImpl
//import com.abaferastech.watermyplants.data.local.PlantDatabase
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object LocalModule {
//
//    @Provides
//    @Singleton
//    fun provideLocalDatabase(app: Application): PlantDatabase {
//        return Room.databaseBuilder(
//            app,
//            PlantDatabase::class.java,
//            "plant_db"
//        ).build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideLocalRepository(db: PlantDatabase): LocalRepository {
//        return LocalRepositoryImpl(db.plantDao)
//    }
//}