package com.startedup.base.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.startedup.base.db.InfluxDao
import com.startedup.base.db.InfluxDataBase
import com.startedup.base.ui.MyApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDataBase(context: Application): InfluxDataBase {
        return Room.databaseBuilder(context, InfluxDataBase::class.java, "InfluxDB").build()
    }


    @Provides
    @Singleton
    fun provideDao(influxDataBase: InfluxDataBase): InfluxDao {
        return influxDataBase.influxDao()
    }

}