package com.startedup.base.ui.influx

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.startedup.base.api.Resource
import com.startedup.base.model.influx.Food
import com.startedup.base.repository.InfluxRepository
import javax.inject.Inject

class InfluxViewModel @Inject constructor(private val influxRepository: InfluxRepository) :
        ViewModel() {

    lateinit var data: LiveData<Resource<Food>>


    fun getFood(): LiveData<Resource<Food>> {
        data = influxRepository.loadFood()
        return data
    }

}