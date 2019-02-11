package com.startedup.base.di

import com.startedup.base.ui.influx.InfluxDetailFragment
import com.startedup.base.ui.influx.InfluxFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeInfluxFragment(): InfluxFragment

    @ContributesAndroidInjector
    abstract fun contributeInfluxDetailFragment(): InfluxDetailFragment

}