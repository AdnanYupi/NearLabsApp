package com.yupi.nearlabsapp.datasource

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDataSourceModule {
    @Singleton
    @Provides
    fun getAppDataSource(): AppDataSource {
        return AppDataSourceImpl()
    }
}