package com.startedup.base.di.module

import com.startedup.base.di.FragmentBuildersModule
import com.startedup.base.ui.influx.InfluxActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class InfluxActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeInfluxActivity(): InfluxActivity
}