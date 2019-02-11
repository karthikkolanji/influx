package com.startedup.base.di.module

import android.app.Application
import android.content.Context
import com.startedup.base.ui.MyApp
import com.startedup.base.utils.ResourceFinder
import com.startedup.base.utils.SharedPrefUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [ApiServiceModule::class,
    RetrofitModule::class, GsonModule::class, OkHttpClientModule::class,
    RepositoryModule::class, DatabaseModule::class, ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideResource(context: Application): ResourceFinder {
        return ResourceFinder(context)
    }

    @Provides
    @Singleton
    fun provideSharedPreference(context: Application): SharedPrefUtil {
        return SharedPrefUtil(context)
    }

}