package com.abaferastech.watermyplants.di

import com.abaferastech.watermyplants.data.local.LocalRepository
import com.abaferastech.watermyplants.data.local.LocalRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideLocalRepo(localRepositoryImpl:LocalRepositoryImpl):LocalRepository
}