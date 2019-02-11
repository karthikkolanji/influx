package com.startedup.base.di.module

import com.startedup.base.api.ApiService
import com.startedup.base.db.InfluxDao
import com.startedup.base.repository.InfluxRepository
import com.startedup.base.utils.AppExecutors
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(apiService: ApiService, influxDao: InfluxDao,appExecutors: AppExecutors):InfluxRepository {

        return InfluxRepository(apiService, influxDao,appExecutors)
    }
}